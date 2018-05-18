package com.lightmock.core.networking

import com.lightmock.core.converter.ToStringConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Llvve on 16/11/2017 AD.
 */

interface ApiInterface {

    val BASE_URL: String
        get() = "http://apidev.handigo.run"

    fun initEndPoint(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun initEndPoint(url: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}