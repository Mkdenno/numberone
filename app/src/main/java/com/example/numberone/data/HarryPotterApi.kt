package com.example.numberone.data

import com.example.numberone.models.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HarryPotterApi {

    @GET("characters")
    suspend fun getCharactersList():CharacterResponse
}