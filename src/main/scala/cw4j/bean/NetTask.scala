package cw4j.bean

/**
  * Created by izumi on 2016/08/02.
  */
class NetTask {
  private var task_id: Int = 0
  private var room: NetRoomTask = null
  private var assigned_by_account: NetAssigner = null
  private var message_id: Int = 0
  private var body: String = null
  private var limit_time: Long = 0L
  private var status: String = null

  def getTask_id: Int = {
    return task_id
  }

  def setTask_id(task_id: Int) {
    this.task_id = task_id
  }

  def getRoom: NetRoomTask = {
    return room
  }

  def setRoom(room: NetRoomTask) {
    this.room = room
  }

  def getAssigned_by_account: NetAssigner = {
    return assigned_by_account
  }

  def setAssigned_by_account(assigned_by_account: NetAssigner) {
    this.assigned_by_account = assigned_by_account
  }

  def getMessage_id: Int = {
    return message_id
  }

  def setMessage_id(message_id: Int) {
    this.message_id = message_id
  }

  def getBody: String = {
    return body
  }

  def setBody(body: String) {
    this.body = body
  }

  def getLimit_time: Long = {
    return limit_time
  }

  def setLimit_time(limit_time: Long) {
    this.limit_time = limit_time
  }

  def getStatus: String = {
    return status
  }

  def setStatus(status: String) {
    this.status = status
  }

  override def toString: String = {
    return "NetTask{" + "task_id=" + task_id + ", room=" + room + ", assigned_by_account=" + assigned_by_account + ", message_id=" + message_id + ", body='" + body + '\'' + ", limit_time=" + limit_time + ", status=" + status + '}'
  }
}