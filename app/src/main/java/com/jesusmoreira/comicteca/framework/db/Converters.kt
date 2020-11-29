package com.jesusmoreira.comicteca.framework.db

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    /*@TypeConverter
    fun fromStatus(value: Int?): Status {
        return value?.let { Status.statusFromInt(value) } ?: Status.NONE
    }

    @TypeConverter
    fun statusToInt(status: Status?): Int {
        return status?.value ?: Status.NONE.value
    }*/
}