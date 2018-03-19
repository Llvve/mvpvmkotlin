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
     * Observable ListData of Versions
     */
    fun getVersions(): LiveData<List<Version>> {
        return versionsLiveData
    }

    /**
     * Indicator to show or hide loading informations
     */
    fun isLoading(): LiveData<Boolean> {
        return loadingLiveData
    }

    /**
     * Sets the Version list contents
     */
    fun setVersions(versionsLiveData: List<Version>) {
        this.versionsLiveData.value = versionsLiveData
    }

    /**
     * Set the Version list contents
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
     * Sets the loading state
     */
    fun setLoading(loadingLiveData: Boolean) {
        this.loadingLiveData.value = loadingLiveData
    }

}