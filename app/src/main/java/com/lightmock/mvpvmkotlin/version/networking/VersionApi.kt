package com.lightmock.mvpvmkotlin.version.networking

import com.lightmock.core.ApiInterface
import com.lightmock.core.data.ApiResponse
import com.lightmock.mvpvmkotlin.version.data.Version
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.logging.Logger

/**
 * Created by Llvve on 16/11/2017 AD.
 */
/**
 * This view connects the view implementation with a presenter.
 */
interface VersionApi: ApiInterface, Callback<ApiResponse<Version>> {

    companion object {
        val LOG = Logger.getLogger(VersionApi::class.java.name)
    }

    interface Endpoint {
        @GET("/api/v1/AppVersion/GetLatestVersion")
        fun getLastVersion(@Query("app_type") appType: Int, @Query("device_type") deviceType: Int): Call<ApiResponse<Version>>
    }

    fun onBinding(version: Version, message: String?, status: Int?)

    fun onFailureBinding(message: String?, status: Int?)

    fun getLastVersion(appType: Int, deviceType: Int): Call<ApiResponse<Version>> {
        val call: Call<ApiResponse<Version>>  = initEndPoint().create(Endpoint::class.java).getLastVersion(appType, deviceType)
        call.enqueue(this)

        return call
    }

    override fun onResponse(call: Call<ApiResponse<Version>>?, response: Response<ApiResponse<Version>>?) {
        if (response!!.isSuccessful && response.body() != null && response.code() == 200) {

            val resp = (response.body() as ApiResponse<Version>)

            if (resp.Status != 200) {
                onFailureBinding(resp.Message, resp.Status)
                return
            }

            try {
                onBinding(resp.data, resp.Message, resp.Status)
            }
            catch (e : Exception) {
                onFailureBinding(e.message, 500)
                e.printStackTrace()
            }

            return
        }

        onFailureBinding(response.message(), response.code())
    }

    override fun onFailure(call: Call<ApiResponse<Version>>?, t: Throwable?) {
        LOG.warning(t!!.message)
        onFailureBinding(t.message, 500)
        t.printStackTrace()
    }
}