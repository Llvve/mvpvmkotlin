package com.lightmock.mvpvmkotlin.version.injection

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.ViewTarget
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ContextModule::class))
class ImageLoaderModule /*(var url: String)*/ {

    private val imageComponent = ImageComponent()

    /**
     * Example of pack of modules varies use in fragment, adapter, etc
     */
    @Provides
    fun glideGet(context: Context): Glide {
        return Glide.get(context)
    }

    @Provides
    fun glideWith(context: Context): RequestManager {
        return Glide.with(context)
    }

    @Provides
    fun load(context: Context): RequestBuilder<Drawable> {
        return Glide.with(context).load(imageComponent.url)
    }

    @Provides
    fun loadInto(context: Context): ViewTarget<ImageView, Drawable> {
        return Glide.with(context).load(imageComponent.url).into(imageComponent.view)
    }

    @Provides
    fun imageComponent(): ImageComponent {
        return imageComponent
    }

}