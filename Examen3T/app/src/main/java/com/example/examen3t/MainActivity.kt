package com.example.examen3t

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.examen3t.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController
    lateinit var navHostFragment:NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController= navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    private fun ventanaDialogo(mensaje:String, titulo:String) {
        AlertDialog.Builder(this).setMessage(mensaje).setTitle(titulo).create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        when(navController.currentDestination?.id){
            R.id.MainFragment -> menuInflater.inflate(R.menu.menu_main, menu)
            R.id.ListaFragment -> menuInflater.inflate(R.menu.lista_menu,menu)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(navController.currentDestination?.id) {
            R.id.MainFragment-> when (item.itemId) {
                                    R.id.action_info -> ventanaDialogo("Proyecto de examen del 3er trimestre", "Información")
                                    else -> super.onOptionsItemSelected(item) }
            R.id.ListaFragment -> when (item.itemId) {
                                    R.id.action_info -> ventanaDialogo("Botnes varios","Opciones")
                                else -> super.onOptionsItemSelected(item) }
        }
        return true
    }



    override fun onSupportNavigateUp(): Boolean {
        navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}