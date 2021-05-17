package com.seanPeters.newsapp.ui.breakingNews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seanPeters.newsapp.data.NewsArticle
import com.seanPeters.newsapp.data.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BreakingNewsViewModel @Inject constructor(private val repository: NewsRepository):ViewModel() {

    private val breakingNewsFlow = MutableStateFlow<List<NewsArticle>>(emptyList())

    val breakingNews: Flow<List<NewsArticle>> = breakingNewsFlow

    init {
        viewModelScope.launch {
            val news = repository.getBreakingNews()
            breakingNewsFlow.value = news
        }
    }





}