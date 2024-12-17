package com.turbomoduleexample.networking

import com.turbomoduleexample.components.AccountData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("accounts/watchlist")
    suspend fun getWatchList(): List<AccountData>
}


public object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}


