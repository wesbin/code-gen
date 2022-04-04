package com.github.wesbin.intellijplugin.ui.sql

import com.github.wesbin.intellijplugin.actions.BindingProperties
import com.github.wesbin.intellijplugin.ui.Observer
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.dsl.gridLayout.HorizontalAlign

class ResultPanel(private val bindingProperties: BindingProperties): Observer {
    private lateinit var textArea: JBTextArea

    override fun update() {
        textArea.text = bindingProperties.text
    }

    fun generatePanel(): DialogPanel {

        return panel {
            row {
                textArea = textArea()
                    .rows(50)
                    .horizontalAlign(HorizontalAlign.FILL)
                    .text(bindingProperties.text)
                    .component
            }
        }
    }
}