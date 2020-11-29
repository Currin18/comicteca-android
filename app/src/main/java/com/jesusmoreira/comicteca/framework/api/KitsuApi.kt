package com.jesusmoreira.comicteca.framework.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.jesusmoreira.comicteca.model.LogIn
import com.jesusmoreira.comicteca.model.Manga
import com.jesusmoreira.comicteca.model.Token
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KitsuApi() {

    private inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U): U? = execute().body()?.f()
    private inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)

    private val client = OkHttpClient().newBuilder().apply {
        interceptors().add(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
    }.build()
    private val gson = GsonBuilder().setLenient().create()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kitsu.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val kitsuService = retrofit.create(KitsuService::class.java)

    suspend fun getToken(userName: String, password: String): Token {
        var token = Token()

//        val body = JSONObject()
//                .put("grant_type", "password")
//                .put("username", userName)
//                .put("password", password)
//                .toString()

        val logIn = LogIn(userName, password)

        kitsuService.getOAuthToken(logIn).unwrapCall {
            token = gson.fromJson<Token>(this.toString())
        }

        return token
    }

    suspend fun getCollection(limit: Int = 15, offset: Int = 0): List<Manga> {
        var list: List<Manga> = listOf()

        kitsuService.getCollection(limit, offset).unwrapCall {
            val json = getAsJsonArray("data")
            list = gson.fromJson<List<Manga>>(json.toString())
//            Log.i("Gateway", "${list[0].attributes?.posterImage?.medium}")
        }

        return list
    }
}