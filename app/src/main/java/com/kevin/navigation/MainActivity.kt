package com.kevin.navigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.kevin.navigation.util.BottomNavigationViewHelper

/**
 * Create by KevinTu on 2018/7/26
 *
 * BottomNavigationView + NavHostFragment
 */
class MainActivity : AppCompatActivity() {

    private var keyBackTime: Long = 0

    private val bottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
    }

    private val navHostFragment by lazy {
        findViewById<View>(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    if (Navigation.findNavController(navHostFragment).currentDestination.id != R.id.homeFragment) {
                        Navigation.findNavController(navHostFragment).navigate(R.id.action_home)
                    }
                }
                R.id.small_video -> {
                    if (Navigation.findNavController(navHostFragment).currentDestination.id != R.id.smallvideoFragment) {
                        Navigation.findNavController(navHostFragment).navigate(R.id.action_smallvideo)
                    }
                }
                R.id.task -> {
                    if (Navigation.findNavController(navHostFragment).currentDestination.id != R.id.taskFragment) {
                        Navigation.findNavController(navHostFragment).navigate(R.id.action_task)
                    }
                }
                R.id.subscription -> {
                    if (Navigation.findNavController(navHostFragment).currentDestination.id != R.id.subscriptionFragment) {
                        Navigation.findNavController(navHostFragment).navigate(R.id.action_subscription)
                    }
                }
                R.id.mine -> {
                    if (Navigation.findNavController(navHostFragment).currentDestination.id != R.id.mineFragment) {
                        Navigation.findNavController(navHostFragment).navigate(R.id.action_mine)
                    }
                }
            }
            true
        }

        Navigation.findNavController(navHostFragment).addOnNavigatedListener { controller, destination ->
            when (destination.id) {
                R.id.homeFragment -> bottomNavigationView.selectedItemId = R.id.home
                R.id.smallvideoFragment -> bottomNavigationView.selectedItemId = R.id.small_video
                R.id.taskFragment -> bottomNavigationView.selectedItemId = R.id.task
                R.id.subscriptionFragment -> bottomNavigationView.selectedItemId = R.id.subscription
                R.id.mineFragment -> bottomNavigationView.selectedItemId = R.id.mine
            }
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