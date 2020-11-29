package com.jesusmoreira.comicteca

import android.app.Application
import androidx.room.Room
import com.jesusmoreira.comicteca.framework.db.AppDatabase

class ComictecaApplication: Application() {
    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        ComictecaApplication.database = Room.databaseBuilder(this,
            AppDatabase::class.java, "master-db").build()
    }
}