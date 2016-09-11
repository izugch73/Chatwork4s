package cw4j.bean

/**
  * Created by izumi on 2016/08/02.
  */
class NetContact {
  private var account_id: Int = 0
  private var room_id: Int = 0
  private var name: String = null
  private var chatwork_id: String = null
  private var organization_id: Int = 0
  private var organization_name: String = null
  private var department: String = null
  private var avatar_image_url: String = null

  def getAccount_id: Int = {
    return account_id
  }

  def setAccount_id(account_id: Int) {
    this.account_id = account_id
  }

  def getRoom_id: Int = {
    return room_id
  }

  def setRoom_id(room_id: Int) {
    this.room_id = room_id
  }

  def getName: String = {
    return name
  }

  def setName(name: String) {
    this.name = name
  }

  def getChatwork_id: String = {
    return chatwork_id
  }

  def setChatwork_id(chatwork_id: String) {
    this.chatwork_id = chatwork_id
  }

  def getOrganization_id: Int = {
    return organization_id
  }

  def setOrganization_id(organization_id: Int) {
    this.organization_id = organization_id
  }

  def getOrganization_name: String = {
    return organization_name
  }

  def setOrganization_name(organization_name: String) {
    this.organization_name = organization_name
  }

  def getDepartment: String = {
    return department
  }

  def setDepartment(department: String) {
    this.department = department
  }

  def getAvatar_image_url: String = {
    return avatar_image_url
  }

  def setAvatar_image_url(avatar_image_url: String) {
    this.avatar_image_url = avatar_image_url
  }

  override def toString: String = {
    return "NetContact{" + "account_id=" + account_id + ", room_id=" + room_id + ", name='" + name + '\'' + ", chatwork_id='" + chatwork_id + '\'' + ", organization_id=" + organization_id + ", organization_name='" + organization_name + '\'' + ", department='" + department + '\'' + ", avatar_image_url='" + avatar_image_url + '\'' + '}'
  }
}