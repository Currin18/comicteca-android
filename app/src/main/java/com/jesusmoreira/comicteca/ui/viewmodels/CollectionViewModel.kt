package com.jesusmoreira.comicteca.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jesusmoreira.comicteca.core.domain.Collection
import kotlinx.coroutines.delay

class CollectionViewModel: ViewModel() {
    val collection: LiveData<List<Collection>> = liveData {
        val collection = loadCollection()
        emit(collection)
    }

    private suspend fun loadCollection(): List<Collection> {
        delay(2000)
        return listOf()
    }
}