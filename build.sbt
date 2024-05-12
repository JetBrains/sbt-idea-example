import org.jetbrains.sbtidea.Keys.*

lazy val myAwesomeFramework =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.1-SNAPSHOT",
      scalaVersion := "2.13.13",
      ThisBuild / intellijPluginName := "My Awesome Framework",
      ThisBuild / intellijBuild      := "231.9011.34",
      ThisBuild / intellijPlatform   := IntelliJPlatform.IdeaCommunity,
      Global / intellijAttachSources := true,
      Compile / javacOptions ++= "--release" :: "17" :: Nil,
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies += "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.5" withSources(),
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories    += baseDirectory.value / "testResources",

      patchPluginXml := pluginXmlOptions { xml =>
        xml.version = version.value
        xml.pluginDescription = Utils.readmeDescriptionExtract(file(".") / "README.md")
      }
    )
