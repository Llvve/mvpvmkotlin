package com.lightmock.mvpvmkotlin.version.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lightmock.mvpvmkotlin.R
import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel
import kotlinx.android.synthetic.main.activity_version.*

/**
 * Created by Llvve on 16/11/2017 AD.
 */
class VersionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_version)

        val versionFragment: VersionFragment = supportFragmentManager.findFragmentById(version_fragment.id) as VersionFragment
        val viewModel:VersionViewModel = ViewModelProviders.of(versionFragment).get(VersionViewModel::class.java)
    }

}