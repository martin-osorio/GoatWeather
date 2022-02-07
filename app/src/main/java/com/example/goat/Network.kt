package com.example.goat

import com.example.goat.model.Forecast
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Network {

    @GET("{latitude}, {longitude}")
    fun getForecast(@Path("latitude") latitude: String, @Path("longitude") longitude: String): Call<Forecast>
    //https://api.darksky.net/forecast/[key]/[latitude],[longitude]

    companion object {
        val baseUrl = "https://api.darksky.net/forecast/d76cdb142a6138e1a2333ce89e5ee4c0/"
        fun init(): Network {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl).build().create(Network::class.java)
        }
    }
}