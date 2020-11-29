package com.jesusmoreira.comicteca.core.data

import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Library
import com.jesusmoreira.comicteca.core.domain.Status

interface CollectionDataSource {

    suspend fun add(collection: Collection)

    suspend fun remove(collection: Collection)

    suspend fun getCollections(): List<Collection>

    suspend fun getCollection(collectionId: Int): Collection

    suspend fun findCollection(name: String): Collection

    suspend fun updateStatus(collectionId: Int, status: Status)

}