package com.lightmock.mvpvmkotlin.version.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.lightmock.mvpvmkotlin.version.data.Version

/**
 * Created by Llvve on 16/11/2017 AD.
 */
class VersionViewModel: ViewModel() {

    /**
     * Holds a list of version data which can be observed and changed
     */
    private val versionsLiveData = MutableLiveData<List<Version>>()

    /**
     * Holds a version data which can be observed and changed
     */
    private val versionLiveData = MutableLiveData<Version>()

    /**
     * Holds the state of loading
     */
    private val loadingLiveData = MutableLiveData<Boolean>()

    /**
     * Holds the val of device
     */
    enum class Device(val value: Int) {
        IOS(1),
        ANDROID(2)
    }

    /**
     * Holds the val of app type
     */
    enum class AppType(val value: Int) {
        HANDIGO(1)
    }

    /**
     * Holds the app type
     */
    private var appType:Int = AppType.HANDIGO.value

    /**
     * Holds the device type
     */
    private var deviceType:Int = Device.ANDROID.value

    /**
     * Observable ListData of Versions
     */
    fun getVersions(): LiveData<List<Version>> {
        return versionsLiveData
    }

    /**
     * Sets the Version list contents
     */
    fun setVersions(versionsLiveData: List<Version>) {
        this.versionsLiveData.value = versionsLiveData
    }

    /**
     * Set the Version content
     */
    fun setVersion(versionLiveData: Version) {
        this.versionLiveData.value = versionLiveData
    }

    /**
     * Observable Data of Version
     */
    fun getVersion(): LiveData<Version> {
        return versionLiveData
    }

    /**
     * Indicator to show or hide loading informations
     */
    fun isLoading(): LiveData<Boolean> {
        return loadingLiveData
    }

    /**
     * Sets the loading state
     */
    fun setLoading(loadingLiveData: Boolean) {
        this.loadingLiveData.value = loadingLiveData
    }

    /**
     * Set the app type
     */
    fun setAppType(appType: Int) {
        this.appType = appType
    }

    /**
     * return app type
     */
    fun getAppType(): Int {
        return appType
    }

    /**
     * Set the device type
     */
    fun setDeviceType(deviceType: Int) {
        this.deviceType = deviceType
    }

    /**
     * return device type
     */
    fun getDeviceType(): Int {
        return deviceType
    }

}