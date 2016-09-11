package cw4j

import java.io.IOException
import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import cw4j.bean.{NetMessage, NetRoomMember, NetSendMessage}
import izumi.cw4j.ChatworkConnection

/**
  * Created by izumi on 2016/09/11.
  */
class ChatworkRoom(token:String, roomId:Int) {

	private val TO_MESSAGE_FORMAT:String = "[To:%s]\n%s";
	private val REPLY_MESSAGE_FORMAT: String = "[rp aid=%s to=%s-%s]\n%s"
	private val INFO_MESSAGE_FORMAT: String = "[info]%s[/info]"
	private val INFO_MESSAGE_FORMAT_WITH_TITLE: String = "[info][title]%s[/title]%s[/info]"

	/**
	  * この部屋のメンバ一覧を取得します。
	  *
	  * @return
	  */
	@throws[IOException]
	def getMembers: Array[NetRoomMember] = new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/rooms/" + this.roomId + "/members", token), classOf[Array[NetRoomMember]])

	/**
	  * この部屋にメッセージを送信します。
	  *
	  * @param message
	  * @return
	  * @throws IOException
	  */
	@throws[IOException]
	def sendMessage(message: String): NetSendMessage = {
		var msgMap = Map("body" -> message)
		new ObjectMapper().readValue(ChatworkConnection.post("https://api.chatwork.com/v1/rooms/" + this.roomId + "/messages", token, msgMap), classOf[NetSendMessage])
	}

	/**
	  * この部屋にInformationとしてタイトル付きのメッセージを送信します。
	  *
	  * @param title
	  * @param message
	  * @return
	  * @throws IOException
	  */
	@throws[IOException]
	def sendInformationMessage(title: String, message: String): NetSendMessage = {
		val infoMsg: String = if (title == null) String.format(INFO_MESSAGE_FORMAT, message)
		else String.format(INFO_MESSAGE_FORMAT_WITH_TITLE, title, message)
		sendMessage(infoMsg)
	}

	/**
	  * この部屋にInformationとしてメッセージを送信します。
	  *
	  * @param message
	  * @return
	  * @throws IOException
	  */
	@throws[IOException]
	def sendInformationMessage(message: String): NetSendMessage = sendInformationMessage(null, message)

	/**
	  * メッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
	  *
	  * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
	  * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
	  * @throws IOException
	  */
	@throws[IOException]
	def getMessages(isUnreadOnly: Boolean): Seq[NetMessage] = {
		val url: String = "https://api.chatwork.com/v1/rooms/" + this.roomId + "/messages?force=" + (if (isUnreadOnly) 0
		else 1)
		val json: String = ChatworkConnection.get(url, token)
		if (json.isEmpty) return Seq.empty[NetMessage]
		new ObjectMapper().readValue(json, classOf[Array[NetMessage]])
	}

	/**
	  * 自分へのリプライ付きのメッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
	  *
	  * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
	  * @param myAccountId  このIDへのリプライもしくはToを検索します
	  * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
	  * @throws IOException
	  */
	@throws[IOException]
	def getReplyOrToMessages(isUnreadOnly: Boolean, myAccountId: Int): Seq[NetMessage] = {
		val allMsg: Seq[NetMessage] = getMessages(isUnreadOnly)
		val toList: util.List[NetMessage] = new util.ArrayList[NetMessage]
		for (msg <- allMsg) {
			if (msg.getBody.indexOf("[To:" + myAccountId + "]") != -1 || msg.getBody.indexOf("[rp aid=" + myAccountId) != -1) toList.add(msg)
		}
		toList.toArray(new Array[NetMessage](toList.size))
	}

	/**
	  * ルームIDを返します。
	  *
	  * @return
	  */
	def getRoomId: Int = roomId

}
