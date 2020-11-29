package com.jesusmoreira.comicteca.core.data

import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Status
import com.jesusmoreira.comicteca.core.domain.Volume

interface VolumeDataSource {

    suspend fun add(collection: Collection, volume: Volume)

    suspend fun remove(collection: Collection, volume: Volume)

    suspend fun getVolumes(): List<Volume>

    suspend fun getVolumes(collection: Collection): List<Volume>

    suspend fun getVolume(volumeId: Int): Volume

    suspend fun findVolume(title: String): Volume

    suspend fun updateStatus(volumeId: Int, status: Status)

}