package com.jesusmoreira.comicteca.framework.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "collections")
data class CollectionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "created_at") val createdAt: Date = Date(),
    @ColumnInfo(name = "updated_at") var updatedAt: Date = Date(),
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "cover") var cover: String?,
    @ColumnInfo(name = "status") var status: Int = 0
)