organization := "uk.gov.gds"

name := "govuk-guice-utils"

version := "0.2-SNAPSHOT"

scalaVersion in ThisProject := "2.10.0"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
    "com.google.inject" % "guice" % "3.0",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

parallelExecution in Test := false

publishArtifact in (Test, packageSrc) := true

publishTo in ThisBuild <<= (version) { version: String =>
    val publishType = if (version.endsWith("SNAPSHOT")) "snapshots" else "releases"
    Some(
        Resolver.file(
            "alphagov github " + publishType,
            file(System.getProperty("user.home") + "/alphagov.github.com/maven/" + publishType)
        )
    )
}
