package com.example.appthemoviedb

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.appthemoviedb.databinding.ActivityMainMovieBinding
import com.example.appthemoviedb.di.components.injector
import com.example.appthemoviedb.utils.viewModel
import com.example.appthemoviedb.viewmodel.MovieDBViewModel
import com.google.android.material.navigation.NavigationView


class MovieMainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy {
        ActivityMainMovieBinding.inflate(layoutInflater)
    }

    private lateinit var toggle: ActionBarDrawerToggle

    private val viewModel: MovieDBViewModel by viewModel {
        injector.movieDBViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getTvShow()
        configureView()
        configureLogoutButton()
    }

    private fun configureLogoutButton() {
        binding.logout.setOnClickListener {
            finish()
        }
    }

    private fun configureView() {
        val toolbar = binding.layoutAppBar.toolbarMain
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        binding.drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.navigation_menu)
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> Toast.makeText(this, "Ir al perfil", Toast.LENGTH_LONG).show()
        }
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}