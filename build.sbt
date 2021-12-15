name := "sbt-getting-started"

version := "0.1"

scalaVersion := "2.13.6"

// We dont need to create the aggregate explicitly sbt will create for us
//lazy val root = project.in(file("."))
//  .aggregate(calculators)

lazy val calculators = project
  .dependsOn(api)
  .settings(
    libraryDependencies ++= Dependencies.calculatorDependencies
  )

lazy val api = project.settings(
  libraryDependencies ++= Dependencies.apiDependencies
)
