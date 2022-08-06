package com.aymen.instantnews.di

import android.content.Context
import com.aymen.instantnews.di.modules.RemoteContractModuleTest
import com.aymen.instantnews.di.modules.RemoteModuleTest
import com.aymen.instantnews.di.modules.RepositoryContractModuleTest
import com.aymen.instantnews.test.UseCaseTest
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// Scope annotation that the AppComponent uses
// Classes annotated with @Singleton will have a unique instance in this Component
@Singleton
// Definition of a Dagger component that adds info from the different modules to the graph
@Component(
    modules = [
        RemoteModuleTest::class,
        RemoteContractModuleTest::class,
        RepositoryContractModuleTest::class]
)
interface ApplicationComponentTest {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponentTest
    }

    fun inject(useCaseTest: UseCaseTest)
}