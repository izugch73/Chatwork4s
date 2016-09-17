name := "Chatwork4s"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.2"
)

// for test
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.2" % "test",
  "org.mockito" % "mockito-core" % "1.10.19" % "test"
)

assemblyOutputPath in assembly := file("./Chatwork4s.jar")