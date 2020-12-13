package uz.company.medicinesearch.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import uz.company.medicinesearch.*
import uz.company.medicinesearch.ui.fragments.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment) as NavHostFragment
        val navController = navHostFragment.navController



        setUpBottomNav(navController)

    }



    private fun setUpBottomNav(navController: NavController){
        bottom_navigation?.let{
            NavigationUI.setupWithNavController(it,navController)
        }
    }


}