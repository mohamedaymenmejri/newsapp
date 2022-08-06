package com.aymen.instantnews.common.archi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aymen.instantnews.common.application.App
import com.aymen.instantnews.common.viewmodel.fatory.ViewModelFactory
import com.aymen.instantnews.di.component.ApplicationComponent
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    ///////////////////////////////////////////////////////////////////////////
    // DI APPLICATION INSTANCE
    //////////////////////////////////////////////////////////////////////////
    val appComponent: ApplicationComponent? by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        (activity?.application as App?)?.appComponentInstance()
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FACTORY INJECTION
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent?.inject(this)
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FRAGMENT EXTENTION
    ///////////////////////////////////////////////////////////////////////////
    /**
     * @author Mohamed Aymen Mejri on 20/02/2019.
     * @since 0.0.1
     *
     * This is viewmodel extension for fragment needed viewmodel provider.
     */
    inline fun <reified T : ViewModel> Fragment.viewModel(): T =
        ViewModelProvider(this, viewModelFactory)[T::class.java]
}
