package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape.proveShapeOf
import PinCodeInformation.db
import slick.dbio.Effect
import slick.sql.FixedSqlAction

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class PinCode(id: Long,
                   profileId: Option[Long],
                   receiptId: Option[String],
                   code: String,
                   used: Boolean,
                   created: Option[DateTime])

trait FoxPinCodeRepository extends PinCodeTable {

  /*def insert(pinCodes: PinCode): Int =
    db.withSession { implicit session =>
      pinCodeQuery.insert(pinCodes)
    }*/

  def batchInsert(pinCodes: List[PinCode]): Future[Option[Int]] =
    db.run(pinCodeQuery ++= pinCodes)

}

object PinCodeInformation {
  val db = Database.forConfig("mysql")
}

trait PinCodeTable {

  val pinCodeQuery: TableQuery[PinCodeInformation] = TableQuery[PinCodeInformation]

  class PinCodeInformation(tag: Tag) extends Table[PinCode](tag, "pin_code") {

    def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def profileId: Rep[Option[Long]] = column[Option[Long]]("profile_id")

    def receiptId: Rep[Option[String]] = column[Option[String]]("snap3_receipt_id")

    def code: Rep[String] = column[String]("code")

    def used: Rep[Boolean] = column[Boolean]("used")

    def created: Rep[Option[DateTime]] = column[Option[DateTime]]("created_date")

    def * = (id, profileId, receiptId, code, used, created) <> (PinCode.tupled, PinCode.unapply)
  }

}
