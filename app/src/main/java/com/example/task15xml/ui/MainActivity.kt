package com.example.task15xml.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.task15xml.R
import com.example.task15xml.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar =binding.toolbar
        setSupportActionBar(toolbar)
        val drawerLayout =binding.main
        val navView : NavigationView =findViewById(R.id.nav)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.sports -> {
                    drawerLayout.closeDrawers()
                    supportFragmentManager.beginTransaction(/**/)
                        .replace(R.id.fragmentContainerView, SportsFragment())
                        .commit()
                }

                R.id.technology -> {
                    drawerLayout.closeDrawers()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, TechnologyFragment())
                        .commit()
                }

                R.id.world -> {
                    drawerLayout.closeDrawers()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, WorldFragment())
                        .commit()
                }
            }
            true
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sports -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, SportsFragment())
                    .commit()
            }
            R.id.technology -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, TechnologyFragment())
                    .commit()
            }
            R.id.world -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, WorldFragment())
                    .commit()
            }
            R.id.exit -> {
                finish()
            }
        }
        return true
    }
}