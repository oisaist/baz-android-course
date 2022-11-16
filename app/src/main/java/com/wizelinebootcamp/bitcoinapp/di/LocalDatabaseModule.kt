package com.wizelinebootcamp.bitcoinapp.di

import android.content.Context
import androidx.room.Room
import com.wizelinebootcamp.bitcoinapp.core.Constants.Companion.CRYPTO_CURRENCY_DATABASE
import com.wizelinebootcamp.bitcoinapp.data.local.db.BookDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideBookDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        BookDatabase::class.java,
        CRYPTO_CURRENCY_DATABASE
    )
        .build()

    @Singleton
    @Provides
    fun provideBookDao(bookDatabase: BookDatabase) = bookDatabase.bookDao()

    @Singleton
    @Provides
    fun provideTickerDao(bookDatabase: BookDatabase) = bookDatabase.tickerDao()

    @Singleton
    @Provides
    fun provideOrderBookDao(bookDatabase: BookDatabase) = bookDatabase.orderBookDao()
}
