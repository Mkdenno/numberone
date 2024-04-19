package com.example.numberone.repository

import com.example.numberone.data.HarryPotterApi
import com.example.numberone.models.Data
import com.example.numberone.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

interface CharacterRepository{
    fun getCharacter(): Flow<Resources<List<Data>>>
}

class CharacterRepositoryImpl(
    private val api: HarryPotterApi
):CharacterRepository{
    override fun getCharacter(): Flow<Resources<List<Data>>> = flow {
        try {
            emit(Resources.Loading())
            val characters=api.getCharactersList().data
            emit(Resources.Success(characters))
        }
        catch (e: Exception){
            emit(Resources.Error(e.message?: "Something went wrong"))
        }
        catch (e: IOException){
            emit(Resources.Error(e.message?: "Network Error"))
        }
        catch (e: RuntimeException){
            emit(Resources.Error(e.message?: "Server Error"))
        }

    }

}