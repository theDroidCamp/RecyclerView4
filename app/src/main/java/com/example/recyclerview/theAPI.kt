package com.example.recyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val  URL = "https://api.simplifiedcoding.in/course-apis/recyclerview/"

interface theAPI {
    @GET("movies")
    fun getApi(): Call<List<Movies>>

    companion object{
        operator fun invoke():theAPI{
            return Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(theAPI::class.java)
        }
    }
}