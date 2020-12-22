lazy val baseSettings: Seq[Setting[_]] = Seq(
  scalaVersion       := "2.13.4",
  scalacOptions     ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions", "-language:existentials",
    "-unchecked",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard"
  ),
  resolvers += Resolver.sonatypeRepo("releases")
)

lazy val LilleFP = project.in(file("."))
  .settings(moduleName := "LilleFP")
  .settings(baseSettings: _*)
  .aggregate(core, slides)
  .dependsOn(core, slides)

lazy val core = project
  .settings(moduleName := "LilleFP-core")
  .settings(baseSettings: _*)
  .settings(libraryDependencies += "io.monix" %% "monix" % "3.3.0")

lazy val slides = project
  .settings(moduleName := "LilleFP-slides")
  .settings(baseSettings: _*)
  .settings(
    mdocIn := baseDirectory.value / "mdoc",
    mdocOut := baseDirectory.value / "../docs",
    cleanFiles := cleanFiles.value :+ baseDirectory.value / "../docs"
  ).dependsOn(core)
  .enablePlugins(MdocPlugin)