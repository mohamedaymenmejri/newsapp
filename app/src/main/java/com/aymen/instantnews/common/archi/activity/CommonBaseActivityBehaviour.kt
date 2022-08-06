package com.aymen.instantnews.common.archi.activity

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.aymen.instantnews.common.utils.LogUtil
import com.aymen.instantnews.di.component.ApplicationComponent

abstract class CommonBaseActivityBehaviour : AppCompatActivity() {

    ///////////////////////////////////////////////////////////////////////////
    // DI APPLICATION INSTANCE
    ///////////////////////////////////////////////////////////////////////////
    lateinit var appComponent: ApplicationComponent

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        LogUtil.i(this, "onCreate")
        super.onCreate(savedInstanceState, persistentState)
    }

    @CallSuper
    override fun onResume() {
        LogUtil.i(this, "onResume")
        super.onResume()
    }

    @CallSuper
    override fun onPause() {
        LogUtil.i(this, "onPause")
        super.onPause()
    }

    @CallSuper
    override fun onDestroy() {
        LogUtil.i(this, "onDestroy")
        super.onDestroy()
    }

    @CallSuper
    override fun onStop() {
        LogUtil.i(this, "onStop")
        super.onStop()
    }

    @CallSuper
    override fun onStart() {
        LogUtil.i(this, "onStart")
        super.onStart()
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Suppress("DEPRECATION")
    override fun getResources(): Resources {
        return super.getResources().apply {
            configuration.fontScale = 1F
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            updateConfiguration(configuration, displayMetrics)
        }
    }
}
