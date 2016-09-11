package izumi.cw4j

import com.fasterxml.jackson.databind.ObjectMapper
import cw4j.ChatworkRoom
import cw4j.bean.{NetChatbotMessage, NetMessage, NetSendMessage}
import junit.framework.TestCase

/**
  * ChatworkRoom class test
  *
  * Created by dys on 2016/08/16.
  */
class ChatworkRoomTest(override val name: String) extends ChatworkTestBase(name) {

	@throws[Exception]
	def testGetMembers() {
		val room: ChatworkRoom = Chatwork4j.getRoom(chatworkAPI, roomId)
		TestCase.assertNotNull(room.getMembers)
	}

	@throws[Exception]
	def testInfoMessage() {
		val room: ChatworkRoom = Chatwork4j.getRoom(chatworkAPI, roomId)
		val info: NetSendMessage = room.sendInformationMessage("INFO MESSAGE")
		TestCase.assertNotNull(info.getMessage_id)
	}

	@throws[Exception]
	def testInfoTitleMessage() {
		val room: ChatworkRoom = Chatwork4j.getRoom(chatworkAPI, roomId)
		val titleInfo: NetSendMessage = room.sendInformationMessage("TITLE MESSAGE", "INFO TITLE")
		TestCase.assertNotNull(titleInfo.getMessage_id)
	}

	@throws[Exception]
	def testGetMessages() {
		val room: ChatworkRoom = Chatwork4j.getRoom(chatworkAPI, roomId)
		val msgs: Seq[NetMessage] = room.getMessages(true)
		TestCase.assertNotNull(msgs)
		for (msg <- msgs) {
			System.out.println(msg.toString)
		}
	}

//	@throws[Exception]
//	def testReplyOrToMessages() {
//		while (true) {
//			val room: ChatworkRoom = Chatwork4j.getRoom(chatworkAPI, roomId)
//			val msgs: Seq[NetMessage] = room.getReplyOrToMessages(true, 1880430)
//			for (msg <- msgs) {
//				// 各メッセージに対して
//				val message: String = msg.getBody.substring(msg.getBody.indexOf("\n") + 1)
//				System.out.println(message)
//				val url: String = "https://chatbot-api.userlocal.jp/api/chat?message=" + message + "&key=a922d80e3d31ff1274b3"
//				val json: String = ChatworkConnection.get(url, null)
//				val ncbm: NetChatbotMessage = new ObjectMapper().readValue(json, classOf[NetChatbotMessage])
//				room.sendMessage("[To:" + msg.getAccount.getAccount_id + "]" + msg.getAccount.getName + "さん\n" + ncbm.getResult)
//			}
//			Thread.sleep(60000)
//		}
//	}
}
