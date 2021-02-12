package org.jetbrains.scala.samples.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull
import org.jetbrains.scala.samples.SamplePluginBundle

@Service
final class ProjectHelloService(project: Project) {
  def getProjectHelloInfo: String =
    SamplePluginBundle.message("hello.from.project.getname", project.getName)
}

object ProjectHelloService {
  def getInstance(@NotNull project: Project): ProjectHelloService =
    project.getService(classOf[ProjectHelloService])
}