package com.digitu.feechr.base.archi.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aymen.instantnews.common.application.App
import com.aymen.instantnews.common.archi.activity.CommonBaseActivityBehaviour
import com.aymen.instantnews.common.utils.LogUtil
import com.aymen.instantnews.common.viewmodel.fatory.ViewModelFactory
import javax.inject.Inject

/**
 * @author Mohamed Aymen Mejri on 20/02/2019.
 * @since 0.0.1
 *
 * This is the base activity that centralize common functions and resources for all Activities.
 */
abstract class BaseDataBindingActivity : CommonBaseActivityBehaviour(), LifecycleObserver {

    companion object {
        private const val CHOSEN_LOCALE = "CHOSEN_LOCALE"
        private const val DEFAULT_LOCALE = "en"
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONFIGURATION
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    protected abstract fun bindLayout()

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FACTORY INJECTION
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    ///////////////////////////////////////////////////////////////////////////
    // DEPENDENCY INJECTION
    ///////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.i(this, "onCreate BaseDataBindingActivity")
        super.onCreate(savedInstanceState)
        appComponent = (application as App).appComponentInstance()
        appComponent.inject(this)
        bindLayout()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL ACTIVITY EXTENTION
    ///////////////////////////////////////////////////////////////////////////
    inline fun <reified T : ViewModel> AppCompatActivity.viewModel(): T =
        ViewModelProvider(this, viewModelFactory)[T::class.java]
}
