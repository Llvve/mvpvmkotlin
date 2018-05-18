package com.lightmock.mvpvmkotlin.version.networking

import com.lightmock.core.networking.ApiResponse
import com.lightmock.mvpvmkotlin.version.data.Version
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Llvve on 16/11/2017 AD.
 */
/**
 * Service is based on API Interface
 */
interface VersionApi {

    /**
     * Request Last version here
     */
    @GET("/api/v1/AppVersion/GetLatestVersion")
    fun getLastVersion(@Query("app_type") appType: Int, @Query("device_type") deviceType: Int): Call<ApiResponse<Version>>

    /**
     * Mock request Last version here
     */
    @GET("/api/v1/AppVersion/GetLatestVersion")
    fun getLastVersionRaw(@Query("app_type") appType: Int, @Query("device_type") deviceType: Int): Call<VersionResponse>

}