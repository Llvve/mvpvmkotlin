package com.lightmock.core.networking

/**
 * Created by Llvve on 13/3/2018 AD.
 */

data class ApiResponse<out T>(val Status: Int, val Message: String, val data: T)