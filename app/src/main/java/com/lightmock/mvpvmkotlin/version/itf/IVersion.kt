package com.lightmock.mvpvmkotlin.version.itf

import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel

interface IVersion {

    interface IView {
        /**
         * Update progress to TextView
         */
        fun updateProgress(progress: String)

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
         * Provides onReload button
         */
        fun onReload()

        /**
         * Provides switched button
         */
        fun onDeviceSwitched(appType: Int, deviceType: Int)
    }
}