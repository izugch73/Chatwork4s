package cw4j.bean

/**
  * Created by izumi on 2016/08/02.
  */
class NetRoomTask {
  private var room_id: Int = 0
  private var name: String = null
  private var icon_path: String = null

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

  def getIcon_path: String = {
    return icon_path
  }

  def setIcon_path(icon_path: String) {
    this.icon_path = icon_path
  }

  override def toString: String = {
    return "NetRoomTask{" + "room_id=" + room_id + ", name='" + name + '\'' + ", icon_path='" + icon_path + '\'' + '}'
  }
}