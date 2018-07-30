package com.kevin.navigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.kevin.navigation.util.BottomNavigationViewHelper

/**
 * Create by KevinTu on 2018/7/26
 *
 * BottomNavigationView + NavHostFragment
 *
 * BottomNavigationView与fragment关联、管理以及切换动画都交于NavigationUI
 */
class Navigation2Activity : AppCompatActivity() {

    private val bottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
    }

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)
    }
}