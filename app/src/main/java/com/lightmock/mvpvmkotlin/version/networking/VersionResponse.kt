package com.lightmock.mvpvmkotlin.version.networking

import com.lightmock.mvpvmkotlin.version.data.Version

/**
 * Created by Llvve on 13/3/2018 AD.
 */

data class VersionResponse(val Status: Int, val Message: String, val data: Version)