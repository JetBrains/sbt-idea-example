// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.scala.samples.listeners

import com.intellij.notification.{Notification, NotificationType, Notifications}
import com.intellij.openapi.fileEditor.{FileEditorManager, FileEditorManagerListener}
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.scala.samples.SamplePluginBundle

class FileOpenedListener extends FileEditorManagerListener {
  override def fileOpened(source: FileEditorManager, file: VirtualFile): Unit = {
    Notifications.Bus.notify(
      new Notification("My Plugin Notification",
        SamplePluginBundle.message("file.opened"),
        SamplePluginBundle.message("name.getname", file.getName),
        NotificationType.INFORMATION)
    )
  }
}
