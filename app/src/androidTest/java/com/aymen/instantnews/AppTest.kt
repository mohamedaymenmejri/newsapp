package com.aymen.instantnews

import com.aymen.instantnews.common.application.App
import com.aymen.instantnews.di.component.ApplicationComponent
import com.aymen.instantnews.di.component.DaggerApplicationComponent

open class AppTest : App() {

    private val appComponent: ApplicationComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun appComponentInstance() = appComponent
}