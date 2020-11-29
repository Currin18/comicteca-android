package com.jesusmoreira.comicteca.framework

import com.jesusmoreira.comicteca.ComictecaApplication
import com.jesusmoreira.comicteca.core.data.LibraryDataSource
import com.jesusmoreira.comicteca.core.domain.Library
import com.jesusmoreira.comicteca.framework.db.entities.LibraryEntity

class RoomLibraryDataSource: LibraryDataSource {

    private val libraryDao = null
//        ComictecaApplication.database?.libraryDao()

    override fun setLibrary(library: Library) {
//        libraryDao?.setLibrary(LibraryEntity())
    }

    override fun getLibrary(): Library {
        return /*libraryDao?.getLibrary()?.let {
            Library(
                id = it.id,
                createdAt = it.createdAt,
                updateAt = it.updatedAt,
            )
        } ?:*/ Library.EMPTY
    }
}