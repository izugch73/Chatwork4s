package izumi.cw4j

import junit.framework.TestCase
import java.io.InputStream
import java.net.URL
import java.util.Properties

/**
  * base class to prepare to call the Chatwork API before the test
  *
  * Created by dys on 2016/08/16.
  */
class ChatworkTestBase(val name: String) extends TestCase(name) {

	protected var chatworkAPI: String = null
	protected var roomId: Int = 0
	final protected val p: Properties = new Properties

	@throws[Exception]
	override protected def setUp() {
		super.setUp()
//		val url:URL = new URL(classOf[ChatworkTestBase].getResource("."), "test.properties")
//		val is = url.openConnection.getInputStream
		val is: InputStream = classOf[ChatworkTestBase].getResourceAsStream("/test.properties")
		p.load(is)
		is.close()
		chatworkAPI = p.getProperty("chatworkAPI")
		roomId = p.getProperty("roomId").toInt
	}

	// to avoid no tests found exception
	def testDummy() {
	}
}
