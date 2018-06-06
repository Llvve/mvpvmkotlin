package com.lightmock.mvpvmkotlin.version.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.lightmock.core.extension.toast
import com.lightmock.mvpvmkotlin.R
import com.lightmock.mvpvmkotlin.databinding.FragmentVersionBinding
import com.lightmock.mvpvmkotlin.teltype.view.TelTypeActivity
import com.lightmock.mvpvmkotlin.version.data.Version
import com.lightmock.mvpvmkotlin.version.injection.ContextModule
import com.lightmock.mvpvmkotlin.version.injection.ImageLoaderModule
import com.lightmock.mvpvmkotlin.version.itf.IVersion
import com.lightmock.mvpvmkotlin.version.presentation.VersionPresenter
import com.lightmock.mvpvmkotlin.version.viewmodel.VersionViewModel
import dagger.Component
import kotlinx.android.synthetic.main.fragment_version.*

/**
 * Created by Llvve on 16/11/2017 AD.
 */
class VersionFragment: Fragment(), IVersion.IView, View.OnClickListener {

    @Component(modules = arrayOf(ImageLoaderModule::class))
    interface VersionComponent {
        fun glideGet(): Glide
        fun glideWith(): RequestManager
    }

    /**
     * Example show 2 types how to handle data from databinding, viewmodel
     */
    private lateinit var binding: FragmentVersionBinding
    private lateinit var viewModel: VersionViewModel
    private lateinit var presenter: VersionPresenter

    private lateinit var component: VersionComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Initiate component
         */
        component = DaggerVersionFragment_VersionComponent
                .builder()
                .contextModule(ContextModule(activity!!))
//                .imageLoaderModule(GlideModule("http://goo.gl/gEgYUd"))
                .build()

        // Observe the viewmodel
        subscribeToViewModel()
    }

    /**
     * Subscribes to the VersionViewModel data.
     */
    private fun subscribeToViewModel() {
        // lateinit viewmodel variable
        viewModel = ViewModelProviders.of(this).get(VersionViewModel::class.java)

        presenter = VersionPresenter(this, viewModel)

        // React to data changes on the version property
        viewModel.getVersion().observe(this, Observer { version ->
            /**
             * Handle observe version data
             * Shows how to manually set text
             */

            // represent it!! for version
            // tv_result.text = "Version ".plus(it!!.device_name)
            binding.data = version
            tv_device.text = "Observe Device : ".plus(version!!.device_name) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // lateinit binding variable
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_version, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Initiate api connection and action listener
         */
        presenter.onViewInit()

//        component.load().into(iv_tmp)
        component.glideWith().load("http://goo.gl/gEgYUd").into(iv_tmp)

        btn_reload.setOnClickListener(this)
        btn_goto_teltype.setOnClickListener(this)
        rad_device_android.setOnClickListener(this)
        rad_device_ios.setOnClickListener(this)
    }

    override fun updateProgress(progress: String) {
        tv_progress.text = progress
    }

    /**
     * Emits when the user clicks the varies action
     */
    override fun onClick(view: View?) {
        when (view!!.id) {
            btn_reload.id -> {
                presenter.onReload()
            }
            btn_goto_teltype.id -> {
                startActivity(TelTypeActivity.newIntent(context!!, viewModel.getVersion().value!!))
//                startActivity(TelTypeActivity.newIntent(context!!, binding.data!!))
            }
            rad_device_android.id -> {
                presenter.onDeviceSwitched(VersionViewModel.AppType.HANDIGO.value, VersionViewModel.Device.ANDROID.value)
            }
            rad_device_ios.id -> {
                presenter.onDeviceSwitched(VersionViewModel.AppType.HANDIGO.value, VersionViewModel.Device.IOS.value)
            }
            else -> {
                // TODO handle more case
            }
        }
    }

    /**
     * Emits when viewmodel bind already
     */
    override fun onBind(viewModel: VersionViewModel) {
        binding.viewModel = viewModel
    }

    override fun onFailureBinding(message: String, status: Int) {
        /**
         * reset data class by using viewmodel observer and databinding
         */
        viewModel.setVersion(Version())
        binding.viewModel = VersionViewModel()
        binding.viewModel!!.setVersion(Version())
        binding.data = Version()

        message.toast(context, Toast.LENGTH_LONG)
    }
}