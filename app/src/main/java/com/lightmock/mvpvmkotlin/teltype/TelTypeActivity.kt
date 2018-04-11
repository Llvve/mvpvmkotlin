package com.lightmock.mvpvmkotlin.teltype

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lightmock.mvpvmkotlin.R
import com.lightmock.mvpvmkotlin.version.data.Version
import kotlinx.android.synthetic.main.fragment_version.*

class TelTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teltype)

        val version = getVersion(intent)

        tv_device.text = "Observe Device : ".plus(version!!.device_name)
    }

    companion object {

        private val EXTRA_VERSION_MODEL = "version_model"

        fun newIntent(context: Context, version: Version): Intent {
            val intent = Intent(context, TelTypeActivity::class.java)
            intent.putExtra(EXTRA_VERSION_MODEL, version)
            return intent
        }

        fun getVersion(intent: Intent): Version? {
            return intent.extras.get(EXTRA_VERSION_MODEL) as Version
        }

        fun setVersion(intent: Intent, version: Version) {
            intent.putExtra(EXTRA_VERSION_MODEL, version)
        }
    }
}
