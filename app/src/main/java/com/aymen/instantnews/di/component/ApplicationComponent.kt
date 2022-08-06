package com.aymen.instantnews.di.component

import android.content.Context
import com.aymen.instantnews.common.archi.fragment.BaseFragment
import com.aymen.instantnews.data.remote.di.RemoteContractModule
import com.aymen.instantnews.data.remote.di.RemoteModule
import com.aymen.instantnews.data.repository.di.RepositoryContractModule
import com.aymen.instantnews.common.archi.activity.BaseActivity
import com.digitu.feechr.base.archi.activity.BaseDataBindingActivity
import com.aymen.instantnews.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// Scope annotation that the AppComponent uses
// Classes annotated with @Singleton will have a unique instance in this Component
@Singleton
// Definition of a Dagger component that adds info from the different modules to the graph
@Component(
    modules = [
        RemoteModule::class,
        RemoteContractModule::class,
        ViewModelModule::class,
        RepositoryContractModule::class]
)
interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(baseFragment: BaseFragment)
    fun inject(baseActivity: BaseActivity)
    fun inject(baseDataBindingActivity: BaseDataBindingActivity)
}
