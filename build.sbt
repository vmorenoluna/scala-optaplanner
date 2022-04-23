name := "scala-optaplanner"

version := "0.1"

scalaVersion := "2.13.1"

val optaPlannerVersion = "8.20.0.Final"
val slf4jVersion = "1.7.36"
val logbackVersion = "1.2.11"
val scalatestVersion = "3.2.11"

libraryDependencies ++= Seq(
  "org.optaplanner" % "optaplanner-core" % optaPlannerVersion,
  "org.optaplanner" % "optaplanner-test" % optaPlannerVersion % Test,
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",
  "org.slf4j" % "slf4j-api" % slf4jVersion,
  "ch.qos.logback" % "logback-classic" % logbackVersion
)