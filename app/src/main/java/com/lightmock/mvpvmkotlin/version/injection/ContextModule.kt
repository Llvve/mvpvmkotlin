package com.lightmock.mvpvmkotlin.version.injection

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ContextModule(internal var context: Context) {

    @Provides
    fun context(): Context {
        return context
    }
}