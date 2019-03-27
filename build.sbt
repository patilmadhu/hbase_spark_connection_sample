import sbtassembly.PathList

name := "hbase_demo_1"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.3.1",
  "org.apache.spark" %% "spark-sql" % "2.3.1")

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.0"
libraryDependencies += "org.apache.hbase" % "hbase-client" % "1.1.2"
libraryDependencies += "org.apache.hbase" % "hbase-common" % "1.1.2"
libraryDependencies += "com.typesafe" % "config" % "1.3.2"

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.startsWith("META-INF") => MergeStrategy.discard
  case PathList("javax", "servlet", xs @_*) => MergeStrategy.first
  case PathList("org", "apache", xs @_*) => MergeStrategy.first
  case "about.html" => MergeStrategy.rename
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}