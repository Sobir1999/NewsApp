package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInctanse
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countrycode: String,pageNumber: Int) =
            RetrofitInctanse.api.getBreakingNews(countrycode,pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
            RetrofitInctanse.api.searchNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteNews(article: Article) = db.getArticleDao().deleteArticle(article)
}