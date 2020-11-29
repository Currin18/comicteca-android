package com.jesusmoreira.comicteca.core.data

import com.jesusmoreira.comicteca.core.domain.Library

interface LibraryDataSource {

    fun setLibrary(library: Library)

    fun getLibrary(): Library

}