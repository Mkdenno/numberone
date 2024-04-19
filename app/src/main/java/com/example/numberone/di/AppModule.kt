package com.example.numberone.di

import com.example.numberone.data.HarryPotterApi
import com.example.numberone.repository.CharacterRepository
import com.example.numberone.repository.CharacterRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule {
    val api: HarryPotterApi
    val characterRepository: CharacterRepository
}

class AppModuleImpl():AppModule{
    override val api: HarryPotterApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.potterdb.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()


    }
    override val characterRepository: CharacterRepository by lazy {
        CharacterRepositoryImpl(api)
    }

}