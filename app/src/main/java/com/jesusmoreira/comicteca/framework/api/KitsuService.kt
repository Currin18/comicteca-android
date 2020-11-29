package com.jesusmoreira.comicteca.framework.api

import com.google.gson.JsonObject
import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Volume
import com.jesusmoreira.comicteca.model.LogIn
import com.jesusmoreira.comicteca.model.Manga
import retrofit2.Call
import retrofit2.http.*

interface KitsuService {

    // Token (OAuth 2)

//    @Headers("Content-Type: application/json")
    @POST("/api/oauth/token")
    fun getOAuthToken(
        @Body logIn: LogIn,
    ): Call<JsonObject>

    // Manga

    @GET("/api/edge/manga")
    fun getCollection(
        @Query("page[limit]") limit: Int = 15,
        @Query("page[offset]") offset: Int = 0,
        @Query("sort") sort: String = "canonicalTitle",
    ): Call<JsonObject>

    @GET("/api/edge/manga/{id}")
    fun getResource(@Path("id") id: Int) : Call<JsonObject>

    // Users

}
