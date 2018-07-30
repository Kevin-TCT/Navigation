package com.kevin.navigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.kevin.navigation.util.BottomNavigationViewHelper

/**
 * Create by KevinTu on 2018/7/26
 *
 * BottomNavigationView + NavHostFragment
 * 自己管理BottomNavigationView与fragment的对应与切换动画
 */
class NavigationActivity : AppCompatActivity() {

    private var keyBackTime: Long = 0

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

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    if (Navigation.findNavController(navHostFragment.view!!).currentDestination.id != R.id.homeFragment) {
                        Navigation.findNavController(navHostFragment.view!!).navigate(R.id.action_home)
                        // Navigation.findNavController(navHostFragment).navigateUp()
                    }
                }
                R.id.smallvideoFragment -> {
                    if (Navigation.findNavController(navHostFragment.view!!).currentDestination.id != R.id.smallvideoFragment) {
                        Navigation.findNavController(navHostFragment.view!!).navigate(R.id.action_smallvideo)
                    }
                }
                R.id.taskFragment -> {
                    if (Navigation.findNavController(navHostFragment.view!!).currentDestination.id != R.id.taskFragment) {
                        Navigation.findNavController(navHostFragment.view!!).navigate(R.id.action_task)
                    }
                }
                R.id.subscriptionFragment -> {
                    if (Navigation.findNavController(navHostFragment.view!!).currentDestination.id != R.id.subscriptionFragment) {
                        Navigation.findNavController(navHostFragment.view!!).navigate(R.id.action_subscription)
                    }
                }
                R.id.mineFragment -> {
                    if (Navigation.findNavController(navHostFragment.view!!).currentDestination.id != R.id.mineFragment) {
                        Navigation.findNavController(navHostFragment.view!!).navigate(R.id.action_mine)
                    }
                }
            }
            true
        }

        Navigation.findNavController(navHostFragment.view!!).addOnNavigatedListener { controller, destination ->
            bottomNavigationView.selectedItemId = destination.id
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - keyBackTime > 3 * 1000) {
            keyBackTime = System.currentTimeMillis()
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show()
            return
        }
        super.onBackPressed()
    }
}