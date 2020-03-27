import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.axtstar"
ThisBuild / organizationName := "axtstar"

lazy val root = (project in file("."))
  .settings(
    name := "ZIO-example",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "1.0.0-RC18-2",
      "dev.zio" %% "zio-streams" % "1.0.0-RC18-2",
      scalaTest % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
