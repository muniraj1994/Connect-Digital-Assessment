
package com.example.connectdigitalassesment.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val MainServer = "https://dummy.restapiexample.com/api/v1/"

    private val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(MainServer)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}
