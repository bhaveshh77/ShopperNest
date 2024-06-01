package com.myapp.shoppernest.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mancj.materialsearchbar.SimpleOnSearchActionListener
import com.myapp.shoppernest.R

import com.myapp.shoppernest.databinding.ActivitySearchBinding
import com.myapp.shoppernest.fragments.ShopFragment
import java.net.URLEncoder

class SearchActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }
//
//    private lateinit var webViewFragment: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val query = intent.getStringExtra("query")


        binding.searchBar.setOnSearchActionListener(object : SimpleOnSearchActionListener() {
            override fun onSearchStateChanged(enabled: Boolean) {
            }

            override fun onSearchConfirmed(text: CharSequence) {
                text.let {
                    val searchQuery = URLEncoder.encode(text.toString(), "UTF-8")

                    if(binding.tabLayout.selectedTabPosition == 0) {
                        val amazonFragment = "https://www.amazon.com/s?k=$searchQuery"
                        amazonFragment.let {
                            val searchFragment = SearchPageFragment.newInstance(it)
                            loadFragment(searchFragment)
                        }
                    }  else {
                        val flipKartFragment = "https://www.flipkart.com/search?q=$searchQuery"
                        flipKartFragment.let {
                            val searchFragment = SearchPageFragment.newInstance(it)
                            loadFragment(searchFragment)
                        }
                    }

                }
            }

            override fun onButtonClicked(buttonCode: Int) {
            }
        })


        // Add tabs to the TabLayout
        binding.tabLayout.apply {
            addTab(newTab().setText("Amazon"))
            addTab(newTab().setText("Flipkart"))
        }

        // Handle tab selection
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
//                        // Load Home Fragment
//                        loadFragment(SearchPageFragment())

                        val amazonFragment = "https://www.amazon.com/s?k=$query"
                        amazonFragment.let {
                            val searchFragment = SearchPageFragment.newInstance(it)
                            loadFragment(searchFragment)
                        }
                    }
                    1 -> {
                        // Load Shop Fragment
                        val flipKartFragment = "https://www.flipkart.com/search?q=$query"
                        flipKartFragment.let {
                            val searchFragment = SearchPageFragment.newInstance(it)
                            loadFragment(searchFragment)
                        }

//                        loadFragment(sear)
                    }
                    else -> throw IllegalStateException("Unexpected position ${tab.position}")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Handle tab unselected
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle tab reselected
            }
        })

        // Load the default fragment
        if (savedInstanceState == null) {
            loadFragment(SearchPageFragment())
        }

        // Handle search
        val amazonFragment = "https://www.amazon.com/s?k=$query"
        amazonFragment.let {
            val searchFragment = SearchPageFragment.newInstance(it)
            loadFragment(searchFragment)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


}