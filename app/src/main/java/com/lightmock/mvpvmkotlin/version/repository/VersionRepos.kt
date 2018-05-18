package com.lightmock.mvpvmkotlin.version.repository

import com.lightmock.core.networking.ApiInterface
import com.lightmock.core.networking.ApiResponse
import com.lightmock.mvpvmkotlin.version.data.Version
import com.lightmock.mvpvmkotlin.version.networking.VersionResponse
import retrofit2.Call
import retrofit2.Callback

interface VersionRepos: ApiInterface, Callback<ApiResponse<Version>> {

    fun getLastVersion(appType: Int, deviceType: Int): Call<ApiResponse<Version>>

    fun getLastVersionRaw(appType: Int, deviceType: Int): Call<VersionResponse>

}