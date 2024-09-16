package com.example.xnewsme.repository

import com.example.xnewsme.api.RetrofitInstance
import com.example.xnewsme.db.ArticleDatabase
import com.example.xnewsme.model.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)

    fun getSavedNews() = db.getArticleDAO().getAllArticles()


}