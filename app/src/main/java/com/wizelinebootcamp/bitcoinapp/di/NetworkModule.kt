package com.wizelinebootcamp.bitcoinapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wizelinebootcamp.bitcoinapp.BuildConfig
import com.wizelinebootcamp.bitcoinapp.data.remote.BitsoApiService
import com.wizelinebootcamp.bitcoinapp.data.remote.RemoteBitsoDataSource
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepository
import com.wizelinebootcamp.bitcoinapp.data.repository.BitsoRepositoryImpl
import com.wizelinebootcamp.bitcoinapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBitsoRepository(
        remoteBitsoDataSource: RemoteBitsoDataSource
    ): BitsoRepository {
        return BitsoRepositoryImpl(remoteBitsoDataSource)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                )
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverter(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideBitsoApiService(retrofit: Retrofit): BitsoApiService = retrofit.create(BitsoApiService::class.java)
}