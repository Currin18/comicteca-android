package com.jesusmoreira.comicteca.framework.db.dao

import androidx.room.*
import com.jesusmoreira.comicteca.framework.db.entities.CollectionEntity
import com.jesusmoreira.comicteca.framework.db.entities.CollectionsWithVolumesEntity

@Dao
interface CollectionDao {
    @Insert
    fun add(collection: CollectionEntity)

    @Delete
    fun remove(collection: CollectionEntity)

    @Query("SELECT * FROM collections")
    fun getCollections(): List<CollectionEntity>

    @Transaction
    @Query("SELECT * FROM collections")
    fun getCollectionsWithVolumes(): List<CollectionsWithVolumesEntity>

    @Query("UPDATE collections SET status = :status WHERE id = :id")
    fun updateStatus(id: Int, status: Int)
}