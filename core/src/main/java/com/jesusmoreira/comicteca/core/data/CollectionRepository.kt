package com.jesusmoreira.comicteca.core.data

import com.jesusmoreira.comicteca.core.domain.Collection

class CollectionRepository(
    private val collectionSource: CollectionDataSource,
//    private val librarySource: LibraryDataSource,
) {
    suspend fun addCollection(collection: Collection) =
        collectionSource.add(collection)

    suspend fun removeCollection(collection: Collection) =
        collectionSource.remove(collection)

    suspend fun getCollections() =
        collectionSource.getCollections()

    /*fun setLibrary(library: Library) =
        librarySource.setLibrary(library)

    fun getLibrary() =
        librarySource.getLibrary()*/
}