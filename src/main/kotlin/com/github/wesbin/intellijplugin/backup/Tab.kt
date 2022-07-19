package com.github.wesbin.intellijplugin.backup

import org.jetbrains.annotations.ApiStatus

@ApiStatus.Internal
@Target(AnnotationTarget.FUNCTION)
internal annotation class Tab(
    val title: String
)