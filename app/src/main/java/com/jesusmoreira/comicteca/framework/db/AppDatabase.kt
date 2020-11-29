package com.jesusmoreira.comicteca.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jesusmoreira.comicteca.framework.db.dao.CollectionDao
import com.jesusmoreira.comicteca.framework.db.dao.LibraryDao
import com.jesusmoreira.comicteca.framework.db.dao.VolumeDao
import com.jesusmoreira.comicteca.framework.db.entities.CollectionEntity
import com.jesusmoreira.comicteca.framework.db.entities.LibraryEntity
import com.jesusmoreira.comicteca.framework.db.entities.VolumeEntity

@Database(version = 1, entities = [LibraryEntity::class, CollectionEntity::class, VolumeEntity::class])
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
//    abstract fun libraryDao(): LibraryDao
    abstract fun volumeDao(): VolumeDao
    abstract fun collectionDao(): CollectionDao
}