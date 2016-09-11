package cw4j.bean

/**
  * Created by izumi on 2016/08/01.
  */
class NetMe {
  private var account_id: Int = 0
  private var room_id: Int = 0
  private var name: String = null
  private var chatwork_id: String = null
  private var organization_id: Int = 0
  private var organization_name: String = null
  private var department: String = null
  private var title: String = null
  private var url: String = null
  private var introduction: String = null
  private var mail: String = null
  private var tel_organization: String = null
  private var tel_extension: String = null
  private var tel_mobile: String = null
  private var skype: String = null
  private var facebook: String = null
  private var twitter: String = null
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

  def getTitle: String = {
    return title
  }

  def setTitle(title: String) {
    this.title = title
  }

  def getUrl: String = {
    return url
  }

  def setUrl(url: String) {
    this.url = url
  }

  def getIntroduction: String = {
    return introduction
  }

  def setIntroduction(introduction: String) {
    this.introduction = introduction
  }

  def getMail: String = {
    return mail
  }

  def setMail(mail: String) {
    this.mail = mail
  }

  def getTel_organization: String = {
    return tel_organization
  }

  def setTel_organization(tel_organization: String) {
    this.tel_organization = tel_organization
  }

  def getTel_extension: String = {
    return tel_extension
  }

  def setTel_extension(tel_extension: String) {
    this.tel_extension = tel_extension
  }

  def getTel_mobile: String = {
    return tel_mobile
  }

  def setTel_mobile(tel_mobile: String) {
    this.tel_mobile = tel_mobile
  }

  def getSkype: String = {
    return skype
  }

  def setSkype(skype: String) {
    this.skype = skype
  }

  def getFacebook: String = {
    return facebook
  }

  def setFacebook(facebook: String) {
    this.facebook = facebook
  }

  def getTwitter: String = {
    return twitter
  }

  def setTwitter(twitter: String) {
    this.twitter = twitter
  }

  def getAvatar_image_url: String = {
    return avatar_image_url
  }

  def setAvatar_image_url(avatar_image_url: String) {
    this.avatar_image_url = avatar_image_url
  }

  override def toString: String = {
    return "NetMe{" + "account_id=" + account_id + ", room_id=" + room_id + ", name='" + name + '\'' + ", chatwork_id='" + chatwork_id + '\'' + ", organization_id=" + organization_id + ", organization_name='" + organization_name + '\'' + ", department='" + department + '\'' + ", title='" + title + '\'' + ", url='" + url + '\'' + ", introduction='" + introduction + '\'' + ", mail='" + mail + '\'' + ", tel_organization='" + tel_organization + '\'' + ", tel_extension='" + tel_extension + '\'' + ", tel_mobile='" + tel_mobile + '\'' + ", skype='" + skype + '\'' + ", facebook='" + facebook + '\'' + ", twitter='" + twitter + '\'' + ", avatar_image_url='" + avatar_image_url + '\'' + '}'
  }
}