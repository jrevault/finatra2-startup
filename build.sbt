name := "my-api"
 
version := "1.0"
 
scalaVersion := "2.11.7"
 
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)
 
lazy val versions = new {
  val finatra = "2.1.2"
  val logback = "1.1.3"
  val guice = "4.0"
}

libraryDependencies ++= Seq(
  "com.twitter.finatra" % "finatra-http_2.11" % versions.finatra,
  "com.twitter.finatra" % "finatra-slf4j_2.11" % versions.finatra,
  "com.twitter.finatra" % "finatra-jackson_2.11" % versions.finatra,
  "com.twitter.finatra" % "finatra-http_2.11" % versions.finatra % "test",
  "com.twitter.inject" % "inject-server_2.11" % versions.finatra % "test",
  "com.twitter.inject" % "inject-app_2.11" % versions.finatra % "test",
  "com.twitter.inject" % "inject-core_2.11" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",
  "com.twitter.finatra" % "finatra-jackson_2.11" % versions.finatra % "test",
  "com.twitter.finatra" % "finatra-http_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" % "inject-server_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" % "inject-app_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" % "inject-core_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" % "inject-modules_2.11" % versions.finatra % "test" classifier "tests",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test" classifier "tests",
  "com.twitter.finatra" % "finatra-jackson_2.11" % versions.finatra % "test" classifier "tests",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test",
  // ***************************************
  // **** DB Stuffs
  "org.jooq" % "jooq" % "3.7.1",
  "org.jooq" % "jooq-meta" % "3.7.1",
  "org.jooq" % "jooq-codegen" % "3.7.1",
  "org.jooq" % "jooq-scala" % "3.7.1",
  "com.zaxxer" % "HikariCP" % "2.4.3",
  // **** SQL Drivers
  "com.h2database" % "h2" % "1.4.190",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  "net.sourceforge.jtds" % "jtds" % "1.3.1",
  "org.apache.derby" % "derby" % "10.9.1.0"
  // ***************************************
)