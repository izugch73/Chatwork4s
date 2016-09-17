package izumi.cw4j.bean

/**
  * Created by izumi on 2016/08/02.
  */
case class NetContact(
                       account_id: Int,
                       room_id: Int,
                       name: String,
                       chatwork_id: String,
                       organization_id: Int,
                       organization_name: String,
                       department: String,
                       avatar_image_url: String
                     )