package com.lightmock.mvpvmkotlin.version.presenter

import com.lightmock.mvpvmkotlin.version.data.Version
import com.lightmock.mvpvmkotlin.version.networking.VersionApi
import com.lightmock.mvpvmkotlin.version.view.IVersion
import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel
import kotlin.properties.Delegates

/**
 * Created by Llvve on 16/11/2017 AD.
 */
class VersionPresenter(iView: IVersion.IView, viewModel: VersionViewModel): VersionApi, IVersion.IPresenter {

    private var iView: IVersion.IView by Delegates.notNull()
    private var viewModel: VersionViewModel by Delegates.notNull()

    /**
     * Internal presenter cache to store version data
     */
    private val versionCache: MutableList<Version> = mutableListOf()

    init {
        this.iView = iView
        this.viewModel = viewModel
    }

    override fun onBinding(version: Version, message: String?, status: Int?) {
        iView.updateProgress("Retrieve last version complete")
        viewModel.setVersion(version)
        iView.onBind(viewModel)
    }

    override fun onFailureBinding(message: String, status: Int) {
        iView.onFailureBinding(message, status)
    }

    override fun onViewInit() {
        iView.updateProgress("Retrieving last version")
        getLastVersion(1,  2) // 1 = user, 2 = android
    }

    override fun onReload(appType: Int, deviceType: Int) {
        iView.updateProgress("Reload last version")
        getLastVersion(appType,  deviceType) // 1 = user, 2 = android
    }
}