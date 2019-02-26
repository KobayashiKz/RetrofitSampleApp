package com.kk.retrofitsampleapp.retrofitsampleapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 2. Retrofit.create()で作成
class RetrofitInstance {

    val service: ApiService = create(ApiService::class.java)

    lateinit var retrofit: Retrofit

    fun <S> create(serviceClass: Class<S>): S {
        val gson = GsonBuilder()
            .serializeNulls()
            .create()

        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://randomuser.me/")
            .client(httpBuilder.build())
            .build()

        return retrofit.create(serviceClass)
    }
}