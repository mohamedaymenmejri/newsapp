package com.aymen.instantnews.common.application

import androidx.multidex.MultiDexApplication
import com.aymen.instantnews.BuildConfig
import com.aymen.instantnews.di.component.ApplicationComponent
import com.aymen.instantnews.di.component.DaggerApplicationComponent
import timber.log.Timber

open class App : MultiDexApplication() {
    //class App : MultiDexApplication(), CameraXConfig.Provider {
    // Instance of the AppComponent that will be used by all the Activities in the project
    private val appComponent: ApplicationComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    open fun appComponentInstance() = appComponent

    ///////////////////////////////////////////////////////////////////////////
    // APPLICATION LIFECYCLE IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreate() {
        super.onCreate()
        //DataBindingUtil.setDefaultComponent(BindingComponent())
        setupTimber()
        setupLogging()
    }

    ///////////////////////////////////////////////////////////////////////////
    // APPLICATION CONFIGURATION IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    /**
     * @author Mohamed Aymen Mejri on 20/02/2019.
     * @since 0.0.1
     *
     * This is for Log in Debug mode.
     */
    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * @author Mohamed Aymen Mejri on 20/02/2019.
     * @since 0.0.1
     *
     * setup Timber for logging in DEBUG Mode.
     */
    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
