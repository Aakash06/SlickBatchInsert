import models.{FoxPinCodeRepository, PinCode}
import org.joda.time.DateTime

import scala.io.{BufferedSource, Source}

object SlickApp extends App {

  val pinCodeRepository: FoxPinCodeRepository.type = FoxPinCodeRepository

  val codesSource: BufferedSource = Source.fromFile("/home/akshay/Downloads/3tl/abc.csv")
  val codes: List[String] = codesSource.getLines().toList
  codesSource.close()

  println(s"Total codes to insert ${codes.size}")
  println(s"Total codes batches to insert ${codes.size / 5000}")

  var count = 0
  val pinCodesList =
    codes map { code =>
      PinCode(count.toLong, None, None, code, used = false, Some(new DateTime(System.currentTimeMillis())))
    }

  pinCodesList.grouped(5000).foreach { pinCode =>
    count += 1
    println("Inserting codes group" + count)
    val insertResult = pinCodeRepository.batchInsert(pinCode)
    println("Insert result for code " + count + " is " + insertResult)
    insertResult
  }

}
