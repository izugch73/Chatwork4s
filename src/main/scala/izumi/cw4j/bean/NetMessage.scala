package izumi.cw4j.bean

/**
  * Created by izumi on 2016/08/01.
  */
case class NetMessage(
                       message_id: Int,
                       account: NetAccount,
                       body: String,
                       send_time: Long,
                       update_time: Long
                     )