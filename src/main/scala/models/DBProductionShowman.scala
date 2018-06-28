package models

import com.jolbox.bonecp.BoneCPDataSource

import scala.util.control.Exception.allCatch

object DBProductionShowman {
  private val jdbcURL = "jdbc:mysql://localhost/marsgac"
  private val username = "root"
  private val password = "root"
  private val driverClass = "com.mysql.jdbc.Driver"

  private val minConnPerPartition = 1
  private val maxConnPerPartition = 1
  private val partitionCount = 1
  val ds = new BoneCPDataSource()
  ds.setJdbcUrl(jdbcURL)
  ds.setUsername(username)
  ds.setPassword(password)
  ds.setMinConnectionsPerPartition(minConnPerPartition)
  ds.setMaxConnectionsPerPartition(maxConnPerPartition)
  ds.setPartitionCount(partitionCount)
  ds.setDriverClass(driverClass)
  ds.setInitSQL("Select 1")

  println(s"Creating datasource connection for microsite with the following details : $ds")
  private val connection = allCatch opt ds.getConnection
  println("Did we get the connection right? - " + connection.isDefined)
  for (con <- connection) con.close()
}