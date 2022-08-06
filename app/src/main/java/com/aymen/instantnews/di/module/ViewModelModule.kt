package com.aymen.instantnews.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aymen.instantnews.common.viewmodel.fatory.ViewModelFactory
import com.aymen.instantnews.common.viewmodel.fatory.ViewModelKey
import com.aymen.instantnews.feature.news.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Binds
    @Singleton
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}
