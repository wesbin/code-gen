package com.github.wesbin.codegen.core.modules.type.kind

import com.github.wesbin.codegen.core.modules.type.MappingDataType
import com.github.wesbin.codegen.core.modules.type.mapping.MappingType

class DateTimeType private constructor(): MappingDataType(){

    companion object {
        val INSTANCE = DateTimeType()
    }

    override val name: String = "DATETIME"
    override val mappingTypes: List<MappingType> = listOf(
        MappingType.LocalDate
    )
}