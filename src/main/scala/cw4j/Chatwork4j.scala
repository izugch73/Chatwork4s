package izumi.cw4j

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

import cw4j.ChatworkRoom
import cw4j.bean.{NetContact, NetMe, NetStatus, NetTask}
import izumi.cw4j.Chatwork4j.ChatworkIcon.ChatworkIcon

object Chatwork4j {
	/**
		* チャットルームを取得します。
		*
		* @param token
		* @param roomId
		* @return
		*/
	def getRoom(token: String, roomId: Int): ChatworkRoom = new ChatworkRoom(token, roomId)

	/**
		* 自分自身の情報を取得します。
		*
		* @param token
		* @return
		*/
	@throws[IOException]
	def getMe(token: String): NetMe = new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/me", token), classOf[NetMe])

	/**
		* 自分の未読数、未読To数、未完了タスク数を返します。
		*
		* @param token
		* @return
		* @throws IOException
		*/
	@throws[IOException]
	def getMyStatus(token: String): NetStatus = new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/my/status", token), classOf[NetStatus])

	/**
		* 自分のタスク一覧を取得します。
		*
		* @param token
		* @param assigner タスクを依頼した人のアカウントID
		* @param status
		* @return
		* @throws IOException
		*/
	@throws[IOException]
	def getMyTasks(token: String, assigner: Int, status: Chatwork4j.TaskStatus): Seq[NetTask] = {
		val url: String = "https://api.chatwork.com/v1/my/tasks?assigned_by_account_id=" + assigner + "&status=" + status.getValue
		val json: String = ChatworkConnection.get(url, token)
		if (json.isEmpty) return List.empty[NetTask]
		new ObjectMapper().readValue(json, classOf[Array[NetTask]])
	}

	/**
		* 自分で設定した自分のタスク一覧を取得します。
		*
		* @param token
		* @param status
		* @return
		* @throws IOException
		*/
	@throws[IOException]
	def getMyTasks(token: String, status: Chatwork4j.TaskStatus): Seq[NetTask] = {
		val assigner: Int = getMe(token).getAccount_id
		val url: String = "https://api.chatwork.com/v1/my/tasks?assigned_by_account_id=" + assigner + "&status=" + status.getValue
		val json: String = ChatworkConnection.get(url, token)
		if (json.isEmpty) return List.empty[NetTask]
		new ObjectMapper().readValue(json, classOf[Array[NetTask]])
	}

	/**
		* 自分のコンタクト一覧を取得します。
		*
		* @param token
		* @return
		* @throws IOException
		*/
	@throws[IOException]
	def getContacts(token: String): Array[NetContact] = new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/contacts", token), classOf[Array[NetContact]])

	/**
		* タスク取得用列挙型
		*/
	final class TaskStatus private(var status: String) {
		def getValue: String = this.status
	}

	/**
		* アイコン用列挙型
		*/
	object ChatworkIcon extends Enumeration {
		type ChatworkIcon = Value
		val group, check, document, meeting, event, project, business, study, security, star, idea, heart, magcup, beer, music, sports, travel = Value
	}

}

class Chatwork4j {
	/**
		*
		* @param name								 部屋名。必須
		* @param members_admin_ids		管理者となるユーザのアカウントIDリスト。必須
		* @param members_member_ids	 通常メンバとなるユーザのアカウントIDリスト。Null可
		* @param members_readonly_ids 閲覧のみメンバとなるユーザのアカウントIDリスト。Null可
		* @param description					部屋の説明。Null可
		* @param icon								 部屋アイコン。Null可
		* @return
		*/
	def createRoom(name: String, members_admin_ids: List[Integer], members_member_ids: List[Integer], members_readonly_ids: List[Integer], description: String, icon: ChatworkIcon): Int = 0
}

