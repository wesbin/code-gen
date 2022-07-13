package com.github.wesbin.intellijplugin.ui.panel

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.CheckBoxList
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import com.intellij.ui.dsl.gridLayout.VerticalAlign

@Suppress("UnstableApiUsage")
class LeftPanel: Panel {

    override fun createPanel(): DialogPanel {
        return panel {
            row() {
                cell(
                    JBScrollPane(
                        CheckBoxList<String>()
                            .apply {
                                setItems(mutableListOf<String>(
                                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"
                                ), null)
                            }
                    )
                )
                    .apply {
                        horizontalAlign(HorizontalAlign.FILL)
                        verticalAlign(VerticalAlign.FILL)
                    }
            }
        }
    }
}