package com.github.wesbin.codegen.core.field.model

import com.github.wesbin.codegen.core.field.Field
import com.github.wesbin.codegen.core.field.FieldModule
import com.intellij.database.model.DasColumn

class ModelFieldModule: FieldModule {

    override fun createTypeField(dasColumn: DasColumn, attributeType: String): Field {
        TODO("Not yet implemented")
    }
}