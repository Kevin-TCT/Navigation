package com.kevin.navigation.util

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log

/**
 * Create by KevinTu on 2018/7/26
 */
object BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    fun disableShiftMode(view : BottomNavigationView) { // NOTE: 2018/7/27 当BottomNavigationView管理的图标个数大于3个时会有位移
        var menuView =  view.getChildAt(0) as BottomNavigationMenuView
        try {
            var shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in (0 until menuView.childCount)) {
                var item = menuView.getChildAt(i) as BottomNavigationItemView
                //noinspection RestrictedApi
                item.setShiftingMode(false)
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }
    }
}