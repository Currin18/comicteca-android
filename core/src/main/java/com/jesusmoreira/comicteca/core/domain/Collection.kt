package com.jesusmoreira.comicteca.core.domain

data class Collection(
    val id: Int = 0,
    var name: String,
    var cover: String? = null,
    var status: Status = Status.NONE,
)