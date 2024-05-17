import org.jetbrains.sbtidea.Keys.*

import sbt.*

def readmeDescriptionExtract(readmeFile: File): String = {
  val readmeContent = IO.read(readmeFile)

  val startMarker = "<!-- Plugin description -->"
  val endMarker = "<!-- Plugin description end -->"
  val startIndex = readmeContent.indexOf(startMarker)
  val endIndex = readmeContent.indexOf(endMarker)

  if (startIndex == -1 || endIndex == -1) {
    throw new Exception("Plugin description section not found in README.md")
  }

  val readmeDescriptionMd = readmeContent.substring(startIndex + startMarker.length, endIndex).trim
  val readmeDescriptionHtml = org.jetbrains.changelog.ExtensionsKt.markdownToHTML(readmeDescriptionMd, "\\n")

  xml.Utility.escape(readmeDescriptionHtml)
}

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
        xml.sinceBuild = (ThisBuild / intellijBuild).value
        xml.pluginDescription = readmeDescriptionExtract(file(".") / "README.md")
      }
    )
