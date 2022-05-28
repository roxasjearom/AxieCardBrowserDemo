package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.di

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.repository.CardRepositoryImpl
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.repository.CardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @ViewModelScoped
    @Binds
    abstract fun bindCardRepository(impl: CardRepositoryImpl): CardRepository
}
