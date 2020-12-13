package com.example.medicinesearch;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new Home())
                    .commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragmet = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragmet = new Home();
                            break;

                        case R.id.nav_royhat:
                            selectedFragmet = new Избранное();
                            break;

                        case R.id.nav_karzina:
                            selectedFragmet = new Корзина();
                            break;

                        case R.id.nav_location:
                            selectedFragmet = new Карта();
                            break;

                        case R.id.nav_menu:
                            selectedFragmet = new Профил();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragmet).commit();
                    return true;
                }
            };
}