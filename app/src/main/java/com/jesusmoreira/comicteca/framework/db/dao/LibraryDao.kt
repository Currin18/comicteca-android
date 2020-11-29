package com.jesusmoreira.comicteca.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jesusmoreira.comicteca.framework.db.entities.LibraryEntity

@Dao
interface LibraryDao {
    @Insert
    fun setLibrary(library: LibraryEntity)

    @Query("SELECT * FROM library")
    fun getLibrary(): LibraryEntity
}