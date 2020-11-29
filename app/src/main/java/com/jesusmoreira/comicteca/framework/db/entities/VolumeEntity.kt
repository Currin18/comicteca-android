package com.jesusmoreira.comicteca.framework.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "volumes")
data class VolumeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "cover") var cover: String? = null,
    @ColumnInfo(name = "status") var status: Int = 0,
    @ColumnInfo(name = "collection_id") var collectionId: Int,
)