package com.kevin.navigation.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kevin.navigation.Navigation2Activity
import com.kevin.navigation.Navigation3Activity
import com.kevin.navigation.R
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.onClick

/**
 * Create by KevinTu on 2018/7/26
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottom_navigation_2_btn.onClick {
            var intent = Intent(activity, Navigation2Activity::class.java)
            activity?.startActivity(intent)
        }

        navigation_btn.onClick {
            var intent = Intent(activity, Navigation3Activity::class.java)
            activity?.startActivity(intent)
        }
    }
}