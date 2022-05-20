package com.example.examen3tfinal

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.examen3tfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController=navHostFragment.navController

        /*appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when (item.itemId) {
            R.id.menu_simple ->
                when(navController.currentDestination?.id){
                    R.id.MainFragment-> navController.navigate(MainFragmentDirections.actionMainFragmentToSimpleFragment())
                    R.id.compuestaFragment -> navController.navigate(CompuestaFragmentDirections.actionCompuestaFragmentToSimpleFragment())
                }
            R.id.menu_compuesta -> when(navController.currentDestination?.id){
                R.id.MainFragment-> navController.navigate(MainFragmentDirections.actionMainFragmentToSimpleFragment())
                R.id.SimpleFragment -> navController.navigate(SimpleFragmentDirections.actionSimpleFragmentToCompuestaFragment())
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

   /* override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}