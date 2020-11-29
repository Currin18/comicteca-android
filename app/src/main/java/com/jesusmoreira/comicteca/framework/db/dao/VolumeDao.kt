package com.jesusmoreira.comicteca.framework.db.dao

import androidx.room.*
import com.jesusmoreira.comicteca.framework.db.entities.VolumeEntity

@Dao
interface VolumeDao {
    @Insert
    fun add(volume: VolumeEntity)

    @Delete
    fun remove(volume: VolumeEntity)

    @Query("SELECT * FROM volumes")
    fun getVolumes(): List<VolumeEntity>

    @Query("SELECT * FROM volumes WHERE collection_id = :collectionId")
    fun getVolumes(collectionId: Int): List<VolumeEntity>

    @Update
    fun updateVolume(volume: VolumeEntity)
}