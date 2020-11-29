package com.jesusmoreira.comicteca.framework.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "collections_volumes")
class CollectionsWithVolumesEntity(
    @Embedded val collections: CollectionEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "collection_id"
    )
    val volumes: List<VolumeEntity>
)