package izumi.cw4j

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import izumi.cw4j.bean.{NetMessage, NetRoomMember, NetSendMessage}

/**
  * Created by izumi on 2016/09/11.
  */
class ChatworkRoom(
                    token: String,
                    val roomId: Int) {

  val mapper = new ObjectMapper
  mapper.registerModule(DefaultScalaModule)

  /**
    * この部屋のメンバ一覧を取得します。
    *
    * @return
    */
  def members(): Seq[NetRoomMember] = {
    mapper.readValue(ChatworkConnection.get("https://api.chatwork.com/v1/rooms/" + roomId + "/members", token), classOf[Seq[NetRoomMember]])
  }

  /**
    * この部屋にメッセージを送信します。
    *
    * @param message メッセージ
    * @return
    */
  def sendMessage(message: String): NetSendMessage = {
    val msgMap = Map("body" -> message)
    mapper.readValue(ChatworkConnection.post("https://api.chatwork.com/v1/rooms/" + roomId + "/messages", token, msgMap), classOf[NetSendMessage])
  }

  /**
    * この部屋にInformationとしてタイトル付きのメッセージを送信します。
    *
    * @param title   タイトル。タイトルを付けない場合はNone
    * @param message メッセージ
    * @return
    */
  def sendInformationMessage(message: String, title: Option[String] = None): NetSendMessage = {
    val infoMsg = title match {
      case Some(t) => ChatworkRoom.InfoMessageFormatWithTitle.format(t, message)
      case None => ChatworkRoom.InfoMessageFormat.format(message)
    }
    sendMessage(infoMsg)
  }

  /**
    * メッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
    *
    * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
    * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
    */
  def messages(isUnreadOnly: Boolean): Seq[NetMessage] = {
    val url = "https://api.chatwork.com/v1/rooms/" + roomId + "/messages?force=" + (if (isUnreadOnly) 0 else 1)
    val json = ChatworkConnection.get(url, token)
    mapper.readValue(json, classOf[Seq[NetMessage]])
  }

  /**
    * 自分へのリプライ付きのメッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
    *
    * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
    * @param myAccountId  このIDへのリプライもしくはToを検索します
    * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
    */
  def replyOrToMessages(isUnreadOnly: Boolean, myAccountId: Int): Seq[NetMessage] = {
    messages(isUnreadOnly)
      .filter(m => m.body.contains("[To:" + myAccountId + "]") || m.body.contains("[rp aid=" + myAccountId))
  }

}

object ChatworkRoom {
  private val ToMessageFormat = "[To:%s]\n%s"
  private val ReplyMessageFormat = "[rp aid=%s to=%s-%s]\n%s"
  private val InfoMessageFormat = "[info]%s[/info]"
  private val InfoMessageFormatWithTitle = "[info][title]%s[/title]%s[/info]"
}
