package com.lightmock.mvpvmkotlin.version.data

import android.databinding.BaseObservable
import java.io.Serializable

/**
 * Created by Llvve on 16/11/2017 AD.
 */

/**
 * The model class to store version data in.
 *
 * @param app_name the app name of the version
 * @param device_name the device name of the version
 * @param status_name the status name of the version
 * @param id the id of the version
 * @param app_type the app type of the version
 * @param device_type the device type of the version
 * @param version the version of the version
 * @param is_force_update the force update of the version
 * @param create_date the create date of the version
 * @param update_date the update date of the version
 * 
 */
data class Version(val app_name: String, val device_name: String, val status_name: String, val id: Int, val app_type: Int,
                   val device_type: Int, val version: String, val is_force_update: Boolean,
                   val create_date: String, val update_date: String, val status: Int, val appType: Int,
                   val deviceType: Int, val versionStatus: String) : BaseObservable(), Serializable {

    constructor() : this("", "", "", 0, 0,
            0, "", false,
            "","", 0, 0,
            0, ""
    )

}