package com.github.wesbin.codegen.dialog

import com.github.wesbin.codegen.dialog.panel.ObservableProperties
import com.github.wesbin.codegen.dialog.util.StringUtil
import com.github.wesbin.codegen.dialog.util.TypeUtil
import com.intellij.database.model.DasColumn
import com.intellij.database.util.DasUtil

object CodeGen {

    // todo id, notnull 등 annotation 붙이는 작업 해야 함
    fun genEntity(observableProperties: ObservableProperties): String {

        val packageName: String =
            observableProperties.selectedPackage?.let { selectedPackage ->
                observableProperties.selectedSourceRoot?.let { selectedSourceRoot ->
                    selectedPackage.text
                        .replace(selectedSourceRoot.second, "")
                        .replace("\\", ".")
                        .substring(1)
                }
            } ?: "com.wesbin.code-gen"

        val imports: MutableSet<String> = mutableSetOf()
        val fields: MutableList<Pair<String, String>> = mutableListOf()

        DasUtil.getColumns(observableProperties.selectedTable).forEach { dasColumn: DasColumn? ->
            if (dasColumn != null) {
                val attributeType = TypeUtil.toAttributeType(dasColumn.dataType)
                val importAttributeType = TypeUtil.toImportAttributeType(attributeType)
                importAttributeType?.let(imports::add)
                fields.add(Pair(attributeType, StringUtil.toCamelCase(dasColumn.name)))
            }
        }

        // use lombok
        imports.add("lombok.Getter")
        imports.add("lombok.Setter")

        // start entity
        var result = """
            |package $packageName
            |
        """.trimMargin()

        // set import
        imports.forEach { s: String -> result += """
            |
            |import $s
        """.trimMargin() }

        // start class
        result += """
            |
            |
            |@Getter
            |@Setter
            |open class ${observableProperties.className} { 
            |
        """.trimMargin()

        // set field
        fields.forEach { (attributeType, attributeName) ->
            result += """
                |
                |   open var $attributeName: $attributeType? = null
                |
            """.trimMargin()
        }

        // end class
        result += """
            |
            |}
            |
        """.trimMargin()

        return result
    }
}