import sbt._

object GdsScalaCommonBuild extends Build {
  lazy val guiceUtils = Project("guice-utils", file("."))
}
