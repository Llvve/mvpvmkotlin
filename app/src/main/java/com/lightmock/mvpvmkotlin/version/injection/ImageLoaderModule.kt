package com.lightmock.mvpvmkotlin.version.injection

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ContextModule::class))
class ImageLoaderModule /*(var url: String)*/ {

    /**
     * Example of pack of modules varies use in fragment, adapter, etc
     */
    @Provides
    fun glideGet(context: Context) : Glide {
        return Glide.get(context)
    }

    @Provides
    fun glideWith(context: Context) : RequestManager {
        return Glide.with(context)
    }

//    @Provides
//    fun load(context: Context, url: String) : RequestBuilder<Drawable> {
//        return Glide.with(context).load(url)
//    }

//    @Provides
//    fun url(): String {
//        return url
//    }
}