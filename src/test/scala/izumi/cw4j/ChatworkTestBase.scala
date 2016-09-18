package izumi.cw4j

import java.net.URL
import java.nio.file.{Files, Path, Paths}
import java.util.Properties

import org.scalatest.mock.MockitoSugar
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{BeforeAndAfter, FunSuite, ShouldMatchers}

import scala.io.Source

/**
  * base class to prepare to call the Chatwork API before the test
  *
  * Created by dys on 2016/08/16.
  */
trait ChatworkTestBase extends FunSuite
  with TableDrivenPropertyChecks
  with ShouldMatchers
  with BeforeAndAfter
  with MockitoSugar {

  protected val properties: Properties = {
    val p = new Properties
    val stream = getClass.getClassLoader.getResourceAsStream("test.properties")
    p.load(stream)
    stream.close()
    println(p.getProperty("chatworkAPI"))
    println(p.getProperty("roomId"))
    p
  }

  protected val chatworkAPI: String = properties.getProperty("chatworkAPI")
  protected val roomId: Int = properties.getProperty("roomId").toInt

}


