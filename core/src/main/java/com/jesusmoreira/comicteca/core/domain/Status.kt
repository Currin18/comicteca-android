package com.jesusmoreira.comicteca.core.domain

enum class Status (val value: Int) {
    NONE(0),
    WANTED(1),
    COLLECTING(2),
    COMPLETED(3),
    READ(4);

    companion object {
        fun statusFromInt(value: Int?): Status = when(value) {
            WANTED.value -> WANTED
            COLLECTING.value -> COLLECTING
            COMPLETED.value -> COMPLETED
            READ.value -> READ
            else -> NONE
        }
    }
}