import laika.api.*
import laika.format.*
import sbt.*

object Utils {
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

    val transformer = Transformer.from(Markdown).to(HTML).using(Markdown.GitHubFlavor).build
    val readmeDescriptionHtml = transformer.transform(readmeDescriptionMd).right.get

    xml.Utility.escape(readmeDescriptionHtml)
  }
}
