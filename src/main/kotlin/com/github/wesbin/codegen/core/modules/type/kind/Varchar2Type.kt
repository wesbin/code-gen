package com.github.wesbin.codegen.core.modules.type.kind

import com.github.wesbin.codegen.core.modules.type.MappingDataType
import com.github.wesbin.codegen.core.modules.type.mapping.MappingType

class Varchar2Type private constructor(): MappingDataType(){

    companion object {
        val INSTANCE = Varchar2Type()
    }

    override val name: String = "VARCHAR2"
    override val mappingTypes: List<MappingType> = listOf(
        MappingType.String
    )
}