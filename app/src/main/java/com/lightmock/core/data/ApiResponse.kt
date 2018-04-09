package com.lightmock.core.data

/**
 * Created by Llvve on 13/3/2018 AD.
 */

data class ApiResponse<out T>(val Status: Int, val Message: String, val data: T)