package models

import scala.slick.driver.MySQLDriver.simple._
import com.github.tototoshi.slick.MySQLJodaSupport._
import models.PinCodeInformation.{db, pinCodeQuery}
import org.joda.time.DateTime
import scala.slick.driver.MySQLDriver
import scala.slick.lifted.{ProvenShape, TableQuery}

case class PinCode(id: Long,
                   profileId: Option[Long],
                   receiptId: Option[String],
                   code: String,
                   used: Boolean,
                   created: Option[DateTime])

object FoxPinCodeRepository {

  def insert(pinCodes: PinCode): Int =
    db.withSession { implicit session =>
      pinCodeQuery.insert(pinCodes)
    }

  def batchInsert(pinCodes: List[PinCode]): Option[Int] =
    db.withSession { implicit session =>
      pinCodeQuery.insertAll(pinCodes: _*)
    }

}

object PinCodeInformation {
  val db: MySQLDriver.backend.DatabaseDef = Database.forDataSource(DBProductionShowman.ds)
  val pinCodeQuery: TableQuery[PinCodeInformation] = TableQuery[PinCodeInformation]
}

private[models] class PinCodeInformation(tag: Tag) extends Table[PinCode](tag, "pin_code") {
  def id: Column[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def profileId: Column[Option[Long]] = column[Option[Long]]("profile_id")

  def receiptId: Column[Option[String]] = column[Option[String]]("snap3_receipt_id")

  def code: Column[String] = column[String]("code")

  def used: Column[Boolean] = column[Boolean]("used")

  def created: Column[Option[DateTime]] = column[Option[DateTime]]("created_date")

  def * : ProvenShape[PinCode] = (id, profileId, receiptId, code, used, created) <> (PinCode.tupled, PinCode.unapply)
}
