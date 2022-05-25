package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.di

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.repository.CardRepositoryImpl
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.repository.CardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindCardRepository(impl: CardRepositoryImpl): CardRepository
}