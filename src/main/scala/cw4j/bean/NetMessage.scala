package cw4j.bean

/**
  * Created by izumi on 2016/08/01.
  */
class NetMessage {
  private var message_id: Int = 0
  private var account: NetAccount = null
  private var body: String = null
  private var send_time: Long = 0L
  private var update_time: Long = 0L

  def getMessage_id: Int = {
    return message_id
  }

  def setMessage_id(message_id: Int) {
    this.message_id = message_id
  }

  def getAccount: NetAccount = {
    return account
  }

  def setAccount(account: NetAccount) {
    this.account = account
  }

  def getBody: String = {
    return body
  }

  def setBody(body: String) {
    this.body = body
  }

  def getSend_time: Long = {
    return send_time
  }

  def setSend_time(send_time: Long) {
    this.send_time = send_time
  }

  def getUpdate_time: Long = {
    return update_time
  }

  def setUpdate_time(update_time: Long) {
    this.update_time = update_time
  }

  override def toString: String = {
    return "NetMessage{" + "message_id=" + message_id + ", account=" + account + ", body='" + body + '\'' + ", send_time=" + send_time + ", update_time=" + update_time + '}'
  }
}