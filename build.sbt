import org.scalastyle.sbt.ScalastylePlugin

name := "scriptForDB"

version := "1.0"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.35",
  "com.typesafe.slick" %% "slick" % "3.2.2",
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0",
  "joda-time" % "joda-time" % "2.7",
  "org.joda" % "joda-convert" % "1.7",
  "commons-io" % "commons-io" % "2.5",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.2")

ScalastylePlugin.projectSettings
