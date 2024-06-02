package com.example.kitchenapp

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val menuButton: ImageButton = findViewById(R.id.menu_button)
        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    setContentView(R.layout.activity_home)
                }
                R.id.nav_search -> {
                    setContentView(R.layout.activity_search)
                }
                R.id.nav_recommend -> {
                    setContentView(R.layout.activity_recommend)
                }
                R.id.nav_detail -> {
                    setContentView(R.layout.activity_detail)
                }
                R.id.nav_comment -> {
                    setContentView(R.layout.activity_comment)
                }
            }
            true
        }

        // 預設顯示首頁
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_home)
            navView.setCheckedItem(R.id.nav_home)
        }
    }
}
