package com.jesusmoreira.comicteca.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jesusmoreira.comicteca.framework.api.KitsuApi
import com.jesusmoreira.comicteca.model.Manga
import kotlinx.coroutines.*

class MainViewModel: ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    private lateinit var logged: MutableLiveData<Boolean>

    fun isLogged(): MutableLiveData<Boolean> {
        if (!::logged.isInitialized) {
            logged = MutableLiveData()
            logged.postValue(false)
        }
        return logged
    }

    fun logIn(userName: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val token = KitsuApi().getToken(userName, password)
            Log.d(TAG, "$token")
            isLogged().postValue(!token.accessToken.isNullOrBlank())
        }
    }

    val mangaList: LiveData<List<Manga>> = liveData {
        val mangaList = loadMangaList()
        emit(mangaList)
    }

    private suspend fun loadMangaList(): List<Manga> {
        delay(2000)
        return withContext(Dispatchers.IO) { KitsuApi().getCollection() }
    }
}