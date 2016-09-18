package izumi.cw4j

import izumi.cw4j.bean.NetSendMessage

/**
  * ChatworkRoom class test
  *
  * Created by dys on 2016/08/16.
  */
class ChatworkRoomTest extends ChatworkTestBase {

  test("members") {
    val room = Chatwork4j.room(chatworkAPI, roomId)
    assert(room.members() != null)
  }

  test("info message") {
    val room = Chatwork4j.room(chatworkAPI, roomId)
    val info = room.sendInformationMessage("INFO MESSAGE")
    assert(info != null)
  }

  test("infoTitleMessage") {
    val room: ChatworkRoom = Chatwork4j.room(chatworkAPI, roomId)
    val titleInfo: NetSendMessage = room.sendInformationMessage("TITLE MESSAGE", Some("INFO TITLE"))
    assert(titleInfo.getMessage_id != null)
  }

  test("messages") {
    val room = Chatwork4j.room(chatworkAPI, roomId)
    val msgs = room.messages(true)
    assert(msgs != null)
  }

  //  test("replyOrToMessages") {
  //    val mapper = new ObjectMapper
  //    mapper.registerModule(DefaultScalaModule)
  //
  //    while (true) {
  //      val room = Chatwork4j.room(chatworkAPI, roomId)
  //      val msgs = room.replyOrToMessages(true, 1880430)
  //      for (msg <- msgs) {
  //        // 各メッセージに対して
  //        val message = msg.body.substring(msg.body.indexOf("\n") + 1)
  //        println(message)
  //        val url = "https://chatbot-api.userlocal.jp/api/chat?message=" + message + "&key=a922d80e3d31ff1274b3"
  //        val json = ChatworkConnection.get(url, null)
  //        val ncbm = mapper.readValue(json, classOf[NetChatbotMessage])
  //        room.sendMessage("[To:" + msg.account.account_id + "]" + msg.account.name + "さん\n" + ncbm.getResult)
  //      }
  //      Thread.sleep(60000)
  //    }
  //  }
}
