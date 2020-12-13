package uz.company.medicinesearch.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import uz.company.medicinesearch.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private var deleteMenu: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarMain)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setUpBottomNav(navController)

        setupActionBarWithNavController(navController)


        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment -> {
                    toolbarMain.title = "Главная"
                }

                R.id.favoritesFragment -> {
                    toolbarMain.title = "Избранное"
                }

                R.id.basketFargment -> {
                    toolbarMain.title = "Корзина"
                }

                R.id.profileFragment -> {
                    toolbarMain.title = "Профил"
                }

                R.id.mapsFragment -> {
                    toolbarMain.title = "Карта"
                }

                R.id.searchFragment -> {
                    toolbarMain.title = "Поиск"
                }

                R.id.medicineFragment->{
                    val name=arguments?.getString("name")
                    name?.let {
                        toolbarMain.title=it
                    }
                }


            }


            deleteMenu?.let {
                it.isVisible = destination?.id == R.id.basketFargment
            }
        }

    }

    private fun setUpBottomNav(navController: NavController) {
        bottom_navigation?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment) as NavHostFragment).navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menu?.let {
            Log.i("asdjhbwvdsg", "dkhbvdv")
            deleteMenu = it.findItem(R.id.delete)
            deleteMenu!!.isVisible = navController.currentDestination?.id == R.id.basketFargment
        }

        return true
    }


}