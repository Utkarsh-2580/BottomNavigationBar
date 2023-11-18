package com.example.bottomnavigationbarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottomNavigationView)

        setFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener{
            val itemids = it.itemId

            when(itemids) {
                R.id.Home -> setFragment(HomeFragment())
                R.id.News -> setFragment(NewsFragment())
                R.id.Profile -> setFragment(ProfileFragment())

                else -> {

                }
            }
            true

        }

    }


    private fun setFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmenttranscation = fragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,fragment)
            commit()
        }
    }
}