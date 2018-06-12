package com.lightmock.mvpvmkotlin.version.injection

import android.widget.ImageView

/**
 * Created by Llvve on 16/11/2017 AD.
 */

/**
 * The model class to store version data in.
 *
 * @param url the url to load Image
 * @param view the view to display image
 *
 */
class ImageComponent {
    lateinit var url: String
    lateinit var view: ImageView
}