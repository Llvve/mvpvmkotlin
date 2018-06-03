package com.lightmock.mvpvmkotlin.version.itf

import com.lightmock.mvpvmkotlin.version.data.Version
import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel

interface IVersion {

    interface IView {
        /**
         * Update progress to TextView
         */
        fun updateProgress(progress: String)

        /**
         * Provides handle bind with VersionViewModel case
         */
        fun onBind(viewModel: VersionViewModel)

//        /**
//         * Provides handle bind with data binding case
//         */
//        fun onBind()

        /**
         * Provides handle failure binding case
         */
        fun onFailureBinding(message: String, status: Int)
    }

    interface IPresenter {
        /**
         * Provides ejection from view to presenter
         */
        fun onBinding(version: Version, message: String?, status: Int?)

        /**
         * Provides ejection from repo to presenter
         */
        fun onFailureBinding(message: String?, status: Int?)

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