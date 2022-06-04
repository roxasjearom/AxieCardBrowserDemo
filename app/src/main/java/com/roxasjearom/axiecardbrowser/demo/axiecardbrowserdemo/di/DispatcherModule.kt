package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.di

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.utils.DefaultCoroutineDispatcher
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.utils.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Singleton
    @Binds
    abstract fun provideDispatcherProvider(impl: DefaultCoroutineDispatcher): DispatcherProvider
}
