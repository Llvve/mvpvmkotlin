package com.lightmock.mvpvmkotlin.version.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lightmock.mvpvmkotlin.R
import com.lightmock.mvpvmkotlin.databinding.ActivityVersionBinding
import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel
import kotlinx.android.synthetic.main.activity_version.*

/**
 * Created by Llvve on 16/11/2017 AD.
 */
class VersionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVersionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_version)

        val versionFragment: VersionFragment = supportFragmentManager.findFragmentById(version_fragment.id) as VersionFragment
        val viewModel: VersionViewModel = ViewModelProviders.of(versionFragment).get(VersionViewModel::class.java)

        viewModel.getVersion().observe(versionFragment, Observer { version ->
            /**
             * Handle observe version data
             * Shows binding data from versionFragment to ActivityBinding
             * Shows how to manually set text
             */
            binding.data = version
            tv_title_device.text = "Title Device : ".plus(version!!.device_name)
        })
    }

}