package cw4j.bean

/**
  * Created by izumi on 2016/08/01.
  */
class NetSendMessage {
  private var message_id: String = null

  def getMessage_id: String = {
    return message_id
  }

  def setMessage_id(message_id: String) {
    this.message_id = message_id
  }

  override def toString: String = {
    return "NetSendMessage{" + "message_id='" + message_id + '\'' + '}'
  }
}