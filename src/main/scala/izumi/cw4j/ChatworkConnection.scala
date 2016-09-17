package izumi.cw4j

import java.io._
import java.net.{URL, URLEncoder}

/**
  * Created by izumi on 2016/08/01.
  */
object ChatworkConnection {

  def get(urlString: String, token: String): String = {
    val e = new URL(urlString)
    val uc = e.openConnection
    uc.setDoOutput(true)
    uc.setRequestProperty("X-ChatWorkToken", token)
    val is = uc.getInputStream
    val reader = new BufferedReader(new InputStreamReader(is))
    var s = reader.readLine
    var str = ""

    while (s != null) {
      println(s)
      str = str + s + "\n"
      s = reader.readLine
    }

    reader.close()
    str
  }

  def post(urlString: String, token: String, header: Map[String, String]): String = {

    val e = new URL(urlString)
    val uc = e.openConnection
    uc.setDoOutput(true)
    uc.setRequestProperty("X-ChatWorkToken", token)
    val os = uc.getOutputStream
    val ps = new PrintStream(os)

    header.foreach((e: (String, String)) => {
      ps.print(e._1 + "=" + URLEncoder.encode(e._2, "UTF-8"))
    })

    ps.close()
    val is = uc.getInputStream
    val reader = new BufferedReader(new InputStreamReader(is))
    var s = reader.readLine
    var str = ""

    while (s != null) {
      println(s)
      str = str + s + "\n"
      s = reader.readLine
    }

    reader.close()
    str
  }
}
