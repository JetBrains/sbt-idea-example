# Sample IntelliJ platorm plugin written in Scala

This is an example IJ plugin written in Scala and managed by SBT.

This is a bare-minimum IJ platform plugin project setup. This project only contains the SBT build and a basic `plugin.xml`

Extended documentation on the build features such as packaging the artifact, uploading to plugin marketpalce, etc. is covered by
the [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) readme

## Quick Start

- Open the `build.sbt` file in IntelliJ IDEA as a project

- To run your plugin, run or debug the `myAwesomeFramework` run configuration

## Example build features

- `intellijBuild` key in build.sbt contains version of the dependency on IDEA, you can change it.

- Don't forget to replace the plugin name in build.sbt. You also need to change name in resources/META-INF/plugin.xml.
