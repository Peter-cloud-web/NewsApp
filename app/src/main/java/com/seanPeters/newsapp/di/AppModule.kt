package com.seanPeters.newsapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.seanPeters.newsapp.api.NewsApi
import com.seanPeters.newsapp.data.NewsArticleDatabase
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(NewsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit):NewsApi =
        retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun providesDatabase(app:Application):NewsArticleDatabase =
        Room.databaseBuilder(app,NewsArticleDatabase::class.java,"news_article_database")
            .fallbackToDestructiveMigration()
            .build()
}