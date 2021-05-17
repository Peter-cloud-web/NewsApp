package com.seanPeters.newsapp.data

import com.seanPeters.newsapp.api.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val newsArticleDatabase: NewsArticleDatabase){

    private val newsArticleDao = newsArticleDatabase.newsArticleDao()

    suspend fun getBreakingNews():List<NewsArticle>{
        val response = newsApi.getBreakingNews()
        val serverBreakingNewsArticles = response.articles
        val breakingNewsArticles = serverBreakingNewsArticles.map { serverBreakingNewsArticles ->
            NewsArticle(
                title = serverBreakingNewsArticles.title,
                url = serverBreakingNewsArticles.url,
                thumbnailUrl = serverBreakingNewsArticles.urlToImage,
                isBookmarked = true
            )
        }
        return breakingNewsArticles
    }
}