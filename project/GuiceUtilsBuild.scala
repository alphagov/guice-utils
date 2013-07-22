import sbt._

object GdsScalaCommonBuild extends Build {
  lazy val guiceUtils = Project("govuk-guice-utils", file("."))
}
