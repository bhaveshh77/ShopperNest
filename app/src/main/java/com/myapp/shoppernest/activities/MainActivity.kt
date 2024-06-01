package com.myapp.shoppernest.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mancj.materialsearchbar.SimpleOnSearchActionListener
import com.myapp.shoppernest.adapters.SectionsPagerAdapter
import com.myapp.shoppernest.databinding.ActivityMainBinding
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)


        binding.searchBar.setOnSearchActionListener(object : SimpleOnSearchActionListener() {
            override fun onSearchStateChanged(enabled: Boolean) {
            }

            override fun onSearchConfirmed(text: CharSequence) {
                text.let {

                    val query = URLEncoder.encode(text.toString(), "UTF-8")

                    // Create an Intent to start the SearchActivity
                    val intent = Intent(this@MainActivity, SearchActivity::class.java)
                    intent.putExtra("query", query)
                    startActivity(intent)
                }
            }

            override fun onButtonClicked(buttonCode: Int) {
            }
        })

        val sectionsPagerAdapter = SectionsPagerAdapter(this@MainActivity)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Shop"
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }.attach()
    }
}