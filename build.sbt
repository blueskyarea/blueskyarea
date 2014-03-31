name := "blueskyarea"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.typesafe.slick" %% "slick" % "2.0.1",
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc41"
)     

play.Project.playScalaSettings
