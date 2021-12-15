import sbt._

object Dependencies {

  val scalaRequests = "com.lihaoyi" %% "requests" % "0.6.9"
  val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "2.0.1"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"

  val commonDependencies: Seq[ModuleID] = Seq(scalaTest % Test)

  val apiDependencies: Seq[ModuleID] = Seq(scalaRequests, scalaXml) ++ commonDependencies

  val calculatorDependencies: Seq[ModuleID] = commonDependencies
}
