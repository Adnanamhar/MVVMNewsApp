package com.adnanamhar.mvvmnewsapp.repository

import com.adnanamhar.mvvmnewsapp.database.ArticleDatabase
import com.adnanamhar.mvvmnewsapp.model.Article
import com.adnanamhar.mvvmnewsapp.network.RetrofitInstance

class NewsRepository(val db: ArticleDatabase) {

    // get semua data untuk ditampilkan di fragment breaking news
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    // membuat database baru di local database
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    // untuk get semua data yang sudah di bookmark
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    // delete database local
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}