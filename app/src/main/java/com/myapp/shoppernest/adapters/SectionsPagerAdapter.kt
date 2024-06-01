package com.myapp.shoppernest.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myapp.shoppernest.fragments.HomeFragment
import com.myapp.shoppernest.fragments.ShopFragment

class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2 // Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> ShopFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}