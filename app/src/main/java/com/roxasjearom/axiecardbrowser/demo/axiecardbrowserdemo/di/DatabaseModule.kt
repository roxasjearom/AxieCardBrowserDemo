package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.di

import android.content.Context
import androidx.room.Room
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.AppDatabase
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.CardLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "origin.db").build()
    }

    @Provides
    fun provideCardLocalDataSource(appDatabase: AppDatabase): CardLocalDataSource {
        return CardLocalDataSource(appDatabase = appDatabase)
    }
}
