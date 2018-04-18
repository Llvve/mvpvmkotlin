package com.lightmock.mvpvmkotlin.teltype.data

import android.databinding.BaseObservable
import java.io.Serializable

/**
 * Created by Llvve on 16/11/2017 AD.
 */

/**
 * The model class to store version data in.
 *
 * @param tel_type the tel type of the device
 * 
 */
data class TelType(val tel_type: String) : BaseObservable(), Serializable