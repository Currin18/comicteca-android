package com.jesusmoreira.comicteca.core.data

import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Status
import com.jesusmoreira.comicteca.core.domain.Volume

class VolumeRepository(private val dataSource: VolumeDataSource) {
    suspend fun addVolume(collection: Collection, volume: Volume) =
        dataSource.add(collection, volume)

    suspend fun removeVolume(collection: Collection, volume: Volume) =
        dataSource.remove(collection, volume)

    suspend fun getVolumes(collection: Collection) =
        dataSource.getVolumes(collection)

    suspend fun updateVolumeStatus(volume: Volume, status: Status) =
        dataSource.updateStatus(volume.id, status)
}