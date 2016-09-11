package cw4j.bean

/**
  * Created by izumi on 2016/08/02.
  */
class NetAssigner {
  private var account_id: Int = 0
  private var name: String = null
  private var avatar_image_url: String = null

  def getAccount_id: Int = {
    return account_id
  }

  def setAccount_id(account_id: Int) {
    this.account_id = account_id
  }

  def getName: String = {
    return name
  }

  def setName(name: String) {
    this.name = name
  }

  def getAvatar_image_url: String = {
    return avatar_image_url
  }

  def setAvatar_image_url(avatar_image_url: String) {
    this.avatar_image_url = avatar_image_url
  }

  override def toString: String = {
    return "NetAssigner{" + "account_id=" + account_id + ", name='" + name + '\'' + ", avatar_image_url='" + avatar_image_url + '\'' + '}'
  }
}