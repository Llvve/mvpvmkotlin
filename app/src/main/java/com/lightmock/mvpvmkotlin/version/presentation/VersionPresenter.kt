package com.lightmock.mvpvmkotlin.version.presentation

import com.lightmock.mvpvmkotlin.version.data.Version
import com.lightmock.mvpvmkotlin.version.itf.IVersion
import com.lightmock.mvpvmkotlin.version.repository.VersionApiRepos
import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel
import kotlin.properties.Delegates

/**
 * Created by Llvve on 16/11/2017 AD.
 */
class VersionPresenter(iView: IVersion.IView, viewModel: VersionViewModel): IVersion.IPresenter {

    private var iView: IVersion.IView by Delegates.notNull()
    private var viewModel: VersionViewModel by Delegates.notNull()
    private var versionApiRepos: VersionApiRepos = VersionApiRepos(this)

    /**
     * Internal presenter cache to store version data
     */
    private val versionCache: MutableList<Version> = mutableListOf()

    init {
        this.iView = iView
        this.viewModel = viewModel
    }

    override fun onBinding(version: Version, message: String?, status: Int?) {
        versionCache.add(version)

        iView.updateProgress("Complete retrieve version")
        viewModel.setVersion(version)

        iView.onBind(viewModel)
    }

    override fun onFailureBinding(message: String?, status: Int?) {
        iView.updateProgress(message!!)
        iView.onFailureBinding(message, status!!)
    }

    override fun onViewInit() {
        iView.updateProgress("Retrieving last version")
        versionApiRepos.getLastVersion(viewModel.getAppType(), viewModel.getDeviceType())
    }

    override fun onReload() {
        iView.updateProgress("Reload last version")
        versionApiRepos.getLastVersion(viewModel.getAppType(), viewModel.getDeviceType())
    }

    override fun onDeviceSwitched(appType: Int, deviceType: Int) {
        viewModel.setAppType(appType)
        viewModel.setDeviceType(deviceType)
    }
}