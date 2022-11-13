import sbtassembly.MergeStrategy

name := "ClientMonitorApi"

enablePlugins(FlywayPlugin)

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.16"

libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "10.2.0"

libraryDependencies += "com.zaxxer" % "HikariCP" % "3.3.1"

libraryDependencies ~= {
  _.map(
    _.exclude("org.slf4j", "slf4j-simple")
  )
}
assemblyMergeStrategy in assembly := {
  case x if x.contains("io.netty.versions.properties") => MergeStrategy.discard
  case x if x.contains("module-info.class") => MergeStrategy.discard
  case x if x.contains("Static") && x.contains("Binder") => MergeStrategy.last
  case PathList("org", "slf4j", xs@_*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

libraryDependencies ++= Seq(
  guice,
  openId,
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play"      %% "scalatestplus-play"       % "2.0.1" % Test,
  "com.microsoft.sqlserver"     % "mssql-jdbc"                % "7.2.2.jre8",
  "ch.qos.logback"              %  "logback-classic"          % "1.2.1",
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-n", "org.downtowndailybread.bethsaida.tag.UnitTest", "-oD")
