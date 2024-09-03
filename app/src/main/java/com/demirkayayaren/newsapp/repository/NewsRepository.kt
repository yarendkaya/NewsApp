package com.demirkayayaren.newsapp.repository

import com.demirkayayaren.newsapp.api.RetrofitInstance
import com.demirkayayaren.newsapp.db.ArticleDatabase
import com.demirkayayaren.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouritesNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)

}