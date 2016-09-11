package izumi.cw4j

import java.io._
import java.net.{MalformedURLException, URL, URLConnection, URLEncoder}

/**
	* Created by izumi on 2016/08/01.
	*/
object ChatworkConnection {

	def get(urlString: String, token: String): String = {
		val e: URL = new URL(urlString)
		val uc: URLConnection = e.openConnection
		uc.setDoOutput(true)
		uc.setRequestProperty("X-ChatWorkToken", token)
		val is: InputStream = uc.getInputStream
		val reader: BufferedReader = new BufferedReader(new InputStreamReader(is))
		var s: String = reader.readLine
		var str: String = ""

		while (s != null) {
			println(s)
			str = str + s + "\n"
			s = reader.readLine
		}

		reader.close()
		str

	}

	def post(urlString: String, token: String, header: Map[String, String]): String = {

		val e: URL = new URL(urlString)
		val uc: URLConnection = e.openConnection
		uc.setDoOutput(true)
		uc.setRequestProperty("X-ChatWorkToken", token)
		val os: OutputStream = uc.getOutputStream
		val ps: PrintStream = new PrintStream(os)

		header.foreach((e: (String,String))  => {
			ps.print(e._1 + "=" + URLEncoder.encode(e._2, "UTF-8"));
		} )

		ps.close()
		val is: InputStream = uc.getInputStream
		val reader: BufferedReader = new BufferedReader(new InputStreamReader(is))
		var s: String = reader.readLine
		var str: String = ""

		while (s != null) {
			println(s)
			str = str + s + "\n"
			s = reader.readLine
		}

		reader.close()
		str

	}


}
