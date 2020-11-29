package com.jesusmoreira.comicteca.framework

import com.jesusmoreira.comicteca.ComictecaApplication
import com.jesusmoreira.comicteca.core.data.VolumeDataSource
import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Status
import com.jesusmoreira.comicteca.core.domain.Volume
import com.jesusmoreira.comicteca.framework.db.entities.VolumeEntity

class RoomVolumeDataSource: VolumeDataSource {

    private var volumeDao = null
//        ComictecaApplication.database?.volumeDao()

    override suspend fun add(collection: Collection, volume: Volume) {
//        volumeDao?.add(entityFromVolume(collection.id, volume))
    }

    override suspend fun remove(collection: Collection, volume: Volume) {
        TODO("Not yet implemented")
    }

    override suspend fun getVolumes(): List<Volume> {
        return /*volumeDao?.getVolumes()?.map {
            volumeFromEntity(it)
        } ?:*/ listOf()
    }

    override suspend fun getVolumes(collection: Collection): List<Volume> {
        return /*volumeDao?.getVolumes(collection.id)?.map {
            volumeFromEntity(it)
        } ?:*/ listOf()
    }

    override suspend fun getVolume(volumeId: Int): Volume {
        TODO("Not yet implemented")
    }

    override suspend fun findVolume(title: String): Volume {
        TODO("Not yet implemented")
    }

    override suspend fun updateStatus(volumeId: Int, status: Status) {
        TODO("Not yet implemented")
    }

    private fun entityFromVolume(collectionId: Int, volume: Volume) =
        VolumeEntity(
            title = volume.title,
            cover = volume.cover,
            status = volume.status.value,
            collectionId = collectionId,
        )

    private fun volumeFromEntity(entity: VolumeEntity) =
        Volume(
            id = entity.id,
            title = entity.title,
            cover = entity.cover,
            status = Status.statusFromInt(entity.status)
        )
}