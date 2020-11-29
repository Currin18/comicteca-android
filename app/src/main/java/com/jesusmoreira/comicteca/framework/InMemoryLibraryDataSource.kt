package com.jesusmoreira.comicteca.framework

import com.jesusmoreira.comicteca.core.data.LibraryDataSource
import com.jesusmoreira.comicteca.core.domain.Library

class InMemoryLibraryDataSource: LibraryDataSource {

    private var localLibrary: Library = Library.EMPTY

    override fun setLibrary(library: Library) {
        localLibrary = library
    }

    override fun getLibrary(): Library = localLibrary
}