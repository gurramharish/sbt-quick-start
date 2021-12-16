import com.typesafe.sbt.packager.docker.ExecCmd

name := "sbt-getting-started"

version := "0.1"

scalaVersion := "2.13.6"

// We dont need to create the aggregate explicitly sbt will create for us
//lazy val root = project.in(file("."))
//  .aggregate(calculators)

lazy val calculators = project
  .dependsOn(api)
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.calculatorDependencies
  )

lazy val api = project
  .enablePlugins(JavaAppPackaging)
  .settings(
  libraryDependencies ++= Dependencies.apiDependencies
)
