package uz.company.medicinesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainWindow : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_window)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, Home())
                    .commit()
        }


    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragmet: Fragment? = null
        when (item.itemId) {
            R.id.nav_home -> selectedFragmet = Home()
            R.id.nav_royhat -> selectedFragmet = Избранное()
            R.id.nav_karzina -> selectedFragmet = Корзина()
            R.id.nav_location -> selectedFragmet = Карта()
            R.id.nav_menu -> selectedFragmet = Профил()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragmet!!).commit()
        true
    }


}