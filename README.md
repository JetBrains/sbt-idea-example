# Sample IntelliJ platform plugin written in Scala

[![JetBrains team project](http://jb.gg/badges/team.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)

<!-- Plugin description -->
This is an example IJ plugin written in Scala and managed by SBT.

Note that the content between the `<!-- Plugin description ...` and `<!-- Plugin description end ...` markers will be used as the plugin description in the `plugin.xml`.
Please replace the placeholder text with the actual description.
<!-- Plugin description end -->

Apart from basic IJ plugin structure this project also provides some example code to play with and demonstrate some IntelliJ platform API features.

Extended documentation on the build features such as packaging the artifact, uploading to plugin marketplace, etc. is covered by
the [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) readme.

## Quick Start

### Work with sbt in the command line

- Test the plugin in IntelliJ IDEA: `sbt runIDE`
- Package the plugin: `sbt packageArtifactZip`

### Work with GitHub Actions

- Push or Pull Request will trigger the GitHub Actions workflow that will build and test the plugin.
- Push a tag (such as `v1.2.3`) to trigger the GitHub Actions workflow that will build and publish the plugin to the GitHub release page. (You may need to set a GitHub token first.)

### Work with IntelliJ IDEA

- Open the `build.sbt` file in IntelliJ IDEA as a project.
- To run your plugin, run or debug the `myAwesomeFramework` run configuration.

## Example build features

- `intellijBuild` key in build.sbt contains version of the dependency on IDEA, you can change it.
- `intellijPlugins` key in build.sbt contains a dependency on the "Properties" IJ plugin.
- there's an external library dependency that will be packaged into your plugin distribution.
- Don't forget to replace the plugin name in build.sbt. You also need to change name in resources/META-INF/plugin.xml.

## Example plugin components

- `PopupDialogAction` creates an action under the "Tools" menu
- `SimpleCompletionContributor` adds the "HELLO" completion item to the values of the properties files
- `FileOpenedListener` shows a popup when a file is opened in the editor
- `ApplicationHelloService` and `ProjectHelloService` show examples of IJ platform service components
- `MyToolWindowFactory` creates a new ToolWindow at the bottom of the window
