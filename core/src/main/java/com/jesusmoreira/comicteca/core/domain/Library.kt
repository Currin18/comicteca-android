package com.jesusmoreira.comicteca.core.domain

import java.util.*

data class Library(
    val id: Int = 0,
    val createdAt: Date? = Date(),
    var updateAt: Date? = Date(),
) {
    companion object {
        val EMPTY = Library()
    }
}