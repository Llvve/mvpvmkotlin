package com.lightmock.mvpvmkotlin.version.view

import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel

interface IVersion {

    interface IView {
        /**
         * Update progress to TextView
         */
        fun updateProgress(progress: String)

        /**
         * Provides on click reload button
         */
        fun onReloadClick()

        /**
         * Provides handle bind case
         */
        fun onBind(viewModel: VersionViewModel)
        /**
         * Provides handle failure binding case
         */
        fun onFailureBinding(message: String, status: Int)
    }

    interface IPresenter {
        /**
         * Provides initiate of view
         */
        fun onViewInit()

        /**
         * Provides initiate of view
         */
        fun onReload(appType: Int, deviceType: Int)
    }
}