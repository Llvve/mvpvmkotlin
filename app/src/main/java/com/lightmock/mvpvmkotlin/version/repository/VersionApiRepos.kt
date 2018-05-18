package com.lightmock.mvpvmkotlin.version.repository

import com.lightmock.core.networking.ApiResponse
import com.lightmock.mvpvmkotlin.version.data.Version
import com.lightmock.mvpvmkotlin.version.itf.IVersion
import com.lightmock.mvpvmkotlin.version.networking.VersionApi
import com.lightmock.mvpvmkotlin.version.networking.VersionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger
import kotlin.properties.Delegates

/**
 * Created by Llvve on 16/11/2017 AD.
 */
/**
 * This view connects the view implementation with a presenter.
 */
class VersionApiRepos(iPresenter: IVersion.IPresenter): VersionRepos {

    private var iPresenter: IVersion.IPresenter by Delegates.notNull()

    companion object {
        val LOG = Logger.getLogger(VersionApiRepos::class.java.name)
    }

    init {
        this.iPresenter = iPresenter
    }

    override fun getLastVersion(appType: Int, deviceType: Int): Call<ApiResponse<Version>> {
        val call: Call<ApiResponse<Version>> = initEndPoint().create(VersionApi::class.java).getLastVersion(appType, deviceType)
        call.enqueue(this)

        return call
    }

    override fun getLastVersionRaw(appType: Int, deviceType: Int): Call<VersionResponse> {
        val call: Call<VersionResponse> = initEndPoint().create(VersionApi::class.java).getLastVersionRaw(appType, deviceType)
        call.enqueue(object : Callback<VersionResponse> {

            override fun onResponse(call: Call<VersionResponse>?, response: Response<VersionResponse>?) {
                // do something
            }

            override fun onFailure(call: Call<VersionResponse>?, t: Throwable?) {
                // do something
            }

        })
        return call
    }

    override fun onResponse(call: Call<ApiResponse<Version>>?, response: Response<ApiResponse<Version>>?) {
        if (response!!.isSuccessful && response.body() != null && response.code() == 200) {

            val resp = (response.body() as ApiResponse<Version>)

            if (resp.Status != 200) {
                iPresenter.onFailureBinding(resp.Message, resp.Status)
                return
            }

            try {
                iPresenter.onBinding(resp.data, resp.Message, resp.Status)
            }
            catch (e : Exception) {
                iPresenter.onFailureBinding(e.message, 500)
                e.printStackTrace()
            }

            return
        }

        iPresenter.onFailureBinding(response.message(), response.code())
    }

    override fun onFailure(call: Call<ApiResponse<Version>>?, t: Throwable?) {
        LOG.warning(t!!.message)
        iPresenter.onFailureBinding(t.message, 500)
        t.printStackTrace()
    }
}