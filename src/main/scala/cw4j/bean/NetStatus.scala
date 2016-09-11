package cw4j.bean

/**
  * Created by izumi on 2016/08/02.
  */
class NetStatus {
  private var unread_room_num: Int = 0
  private var mention_room_num: Int = 0
  private var mytask_room_num: Int = 0
  private var unread_num: Int = 0
  private var mention_num: Int = 0
  private var mytask_num: Int = 0

  def getUnread_room_num: Int = {
    return unread_room_num
  }

  def setUnread_room_num(unread_room_num: Int) {
    this.unread_room_num = unread_room_num
  }

  def getMention_room_num: Int = {
    return mention_room_num
  }

  def setMention_room_num(mention_room_num: Int) {
    this.mention_room_num = mention_room_num
  }

  def getMytask_room_num: Int = {
    return mytask_room_num
  }

  def setMytask_room_num(mytask_room_num: Int) {
    this.mytask_room_num = mytask_room_num
  }

  def getUnread_num: Int = {
    return unread_num
  }

  def setUnread_num(unread_num: Int) {
    this.unread_num = unread_num
  }

  def getMention_num: Int = {
    return mention_num
  }

  def setMention_num(mention_num: Int) {
    this.mention_num = mention_num
  }

  def getMytask_num: Int = {
    return mytask_num
  }

  def setMytask_num(mytask_num: Int) {
    this.mytask_num = mytask_num
  }

  override def toString: String = {
    return "NetStatus{" + "unread_room_num=" + unread_room_num + ", mention_room_num=" + mention_room_num + ", mytask_room_num=" + mytask_room_num + ", unread_num=" + unread_num + ", mention_num=" + mention_num + ", mytask_num=" + mytask_num + '}'
  }
}