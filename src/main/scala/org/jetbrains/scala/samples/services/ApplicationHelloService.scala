package org.jetbrains.scala.samples.services

import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.components.{Service, ServiceManager}
import org.jetbrains.scala.samples.SamplePluginBundle

@Service
final class ApplicationHelloService {
  def getApplicationHelloInfo: String =
    SamplePluginBundle.message("hello.this.is.asstring", ApplicationInfo.getInstance().getBuild.asString())
}

object ApplicationHelloService {
  def getInstance: ApplicationHelloService = ServiceManager.getService(classOf[ApplicationHelloService])
}
