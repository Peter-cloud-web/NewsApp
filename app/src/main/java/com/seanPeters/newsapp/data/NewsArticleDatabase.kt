package com.seanPeters.newsapp.data

import androidx.room.Database

@Database(entities = [NewsArticle::class,BreakingNews::class],version = 1)
abstract class NewsArticleDatabase {

    abstract fun newsArticleDao():NewsArticleDao
}