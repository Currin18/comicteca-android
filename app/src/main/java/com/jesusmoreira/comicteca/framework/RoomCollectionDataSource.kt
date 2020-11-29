package com.jesusmoreira.comicteca.framework

import com.jesusmoreira.comicteca.ComictecaApplication
import com.jesusmoreira.comicteca.core.data.CollectionDataSource
import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Status
import com.jesusmoreira.comicteca.framework.db.entities.CollectionEntity

class RoomCollectionDataSource: CollectionDataSource {

    private val collectionDao =
        ComictecaApplication.database?.collectionDao()

    override suspend fun add(collection: Collection) {
        collectionDao?.add(
            CollectionEntity(
                name = collection.name,
                cover = collection.cover,
                status = collection.status.value
            )
        )
    }

    override suspend fun remove(collection: Collection) {
        TODO("Not yet implemented")
    }

    override suspend fun getCollections(): List<Collection> {
        return collectionDao?.getCollections()?.map {
            Collection(
                id = it.id,
                name = it.name,
                cover = it.cover,
                status = Status.statusFromInt(it.status)
            )
        } ?: listOf()
    }

    override suspend fun getCollection(collectionId: Int): Collection {
        TODO("Not yet implemented")
    }

    override suspend fun findCollection(name: String): Collection {
        TODO("Not yet implemented")
    }

    override suspend fun updateStatus(collectionId: Int, status: Status) {
        TODO("Not yet implemented")
    }

}