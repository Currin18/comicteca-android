package com.jesusmoreira.comicteca.core.domain

data class Volume(
    val id: Int = 0,
    var title: String,
    var cover: String? = null,
    var status: Status = Status.NONE,
)