package com.example.numberone.util

sealed class Resources<out T>{
    class Loading<out T>: Resources<T>()
    class Success<out T> (val data: T): Resources<T>()
    class Error<out T> (val message: String): Resources<T>()

}