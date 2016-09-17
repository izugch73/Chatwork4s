package izumi.cw4j.bean

/**
  * Created by izumi on 2016/08/19
  */
class NetChatbotMessage {
  private var status: String = null
  private var result: String = null

  def getStatus: String = {
    return status
  }

  def setStatus(status: String) {
    this.status = status
  }

  def getResult: String = {
    return result
  }

  def setResult(result: String) {
    this.result = result
  }

  override def toString: String = {
    return "NetChatbotMessage{" + "status='" + status + '\'' + ", result='" + result + '\'' + '}'
  }
}