package com.adnanamhar.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.adnanamhar.mvvmnewsapp.R
import com.adnanamhar.mvvmnewsapp.database.ArticleDatabase
import com.adnanamhar.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}