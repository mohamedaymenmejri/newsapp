package com.aymen.instantnews.common.archi.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aymen.instantnews.common.application.App
import com.aymen.instantnews.common.utils.LogUtil
import com.aymen.instantnews.common.viewmodel.fatory.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity : CommonBaseActivityBehaviour(), LifecycleObserver {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONFIGURATION
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    abstract val defineLayoutBinding: () -> View

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FACTORY INJECTION
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.i(this, "onCreate BaseActivity")
        super.onCreate(savedInstanceState)
        setContentView(defineLayoutBinding())
        appComponent = (application as App).appComponentInstance()
        appComponent.inject(this)
        makeUiFullscreen()
    }

    override fun onResume() {
        super.onResume()
    }

    @CallSuper
    override fun onDestroy() {
        LogUtil.i(this, "onDestroy BaseActivity")
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL ACTIVITY EXTENTION
    ///////////////////////////////////////////////////////////////////////////
    inline fun <reified T : ViewModel> AppCompatActivity.viewModel(): T =
        ViewModelProvider(this, viewModelFactory)[T::class.java]

    ///////////////////////////////////////////////////////////////////////////
    // UI SETUP
    ///////////////////////////////////////////////////////////////////////////
    @Suppress("DEPRECATION")
    private fun makeUiFullscreen() {
        window.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                window.attributes.layoutInDisplayCutoutMode =
                    WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
                window.insetsController?.apply {
                    hide(WindowInsets.Type.statusBars())
                    systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_IMMERSIVE
                                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        )
            }
        }
    }
}
