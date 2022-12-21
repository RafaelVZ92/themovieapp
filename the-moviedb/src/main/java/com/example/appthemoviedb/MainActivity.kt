package com.example.appthemoviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appthemoviedb.databinding.ActivityMainBinding
import com.example.appthemoviedb.di.components.injector
import com.example.appthemoviedb.utils.viewModel
import com.example.appthemoviedb.viewmodel.MovieDBViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MovieDBViewModel by viewModel {
        injector.movieDBViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getTvShow()
    }
}