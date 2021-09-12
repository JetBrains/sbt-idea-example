# Sample IntelliJ platform plugin written in Scala

This is an example IJ plugin written in Scala and managed by SBT.

Apart from basic IJ plugin structure this project also provides some example code to play with and demonstrate some IntelliJ platform API features.

Extended documentation on the build features such as packaging the artifact, uploading to plugin marketplace, etc. is covered by
the [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) readme

## Quick Start

- Open the `build.sbt` file in IntelliJ IDEA as a project
- To run your plugin, run or debug the `myAwesomeFramework` run configuration

## Example build features

- `intellijBuild` key in build.sbt contains version of the dependency on IDEA, you can change it.

- `intellijPlugins` key in build.sbt contains a dependency on the "Properties" IJ plugin

- there's an external library dependency that will be packaged into your plugin distribution

- Don't forget to replace the plugin name in build.sbt. You also need to change name in resources/META-INF/plugin.xml.

## Example plugin components

- `PopupDialogAction` creates an action under the "Tools" menu
- `SimpleCompletionContributor` adds the "HELLO" completion item to the values of the properties files
- `FileOpenedListener` shows a popup when a file is opened in the editor
- `ApplicationHelloService` and `ProjectHelloService` show examples of IJ platform service components
- `MyToolWindowFactory` creates a new ToolWindow at the bottom of the window
