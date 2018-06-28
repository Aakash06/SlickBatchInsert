import org.scalastyle.sbt.ScalastylePlugin

name := "scriptForDB"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.madhukaraphatak" %% "java-sizeof" % "0.1",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "mysql" % "mysql-connector-java" % "5.1.35",
  "net.databinder.dispatch" % "dispatch-core_2.11" % "0.12.0",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "joda-time" % "joda-time" % "2.4",
  "org.joda" % "joda-convert" % "1.6",
  "com.github.tototoshi" %% "slick-joda-mapper" % "1.2.0",
  "commons-io" % "commons-io" % "2.5",
  "com.jolbox" % "bonecp" % "0.8.0.RELEASE",
  "net.liftweb" % "lift-json_2.11" % "2.6-M4",
  "com.github.tminglei" %% "slick-pg" % "0.8.1",
  "com.typesafe.play" %% "play-json" % "2.5.10")

ScalastylePlugin.projectSettings
