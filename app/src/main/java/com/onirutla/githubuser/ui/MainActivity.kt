package com.onirutla.githubuser.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.onirutla.githubuser.MainNavDirections
import com.onirutla.githubuser.R
import com.onirutla.githubuser.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.findNavController()

        with(binding) {
            bottomNav.setupWithNavController(navController = navController)
            fab.setOnClickListener {
                navController.navigate(MainNavDirections.actionGlobalSearchFragment())
            }
        }

        setupDestinationListener(navController)
    }

    private fun setupDestinationListener(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.searchFragment -> {
                    hideBottomAppbar()
                }
                R.id.detailFragment -> {
                    hideBottomAppbar()
                }
                else -> {
                    showBottomAppbar()
                }
            }
        }
    }

    private fun showBottomAppbar() {
        binding.run {
            bottomAppbar.visibility = View.VISIBLE
            bottomAppbar.performShow()
            fab.show()
        }
    }

    private fun hideBottomAppbar() {
        binding.run {
            bottomAppbar.visibility = View.GONE
            bottomAppbar.performHide()
            fab.hide()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}