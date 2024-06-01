package com.myapp.shoppernest.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.myapp.shoppernest.R
import com.myapp.shoppernest.adapters.AppAdapter
import com.myapp.shoppernest.databinding.FragmentHomeBinding
import com.myapp.shoppernest.models.App


class HomeFragment : Fragment() {


    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        binding.recyclerViewTopStores.layoutManager = GridLayoutManager(requireContext(), 4) // Grid layout with 2 columns
        binding.recyclerViewTopStores.adapter = AppAdapter(getTopStoresProducts()) {appUrl ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(appUrl))
            startActivity(intent)
        }

        binding.recyclerViewFood.layoutManager = GridLayoutManager(requireContext(), 4) // Grid layout with 2 columns
        binding.recyclerViewFood.adapter = AppAdapter(getFoodProducts()) {appUrl ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(appUrl))
            startActivity(intent)
        }

        return binding.root
    }

    private fun getTopStoresProducts(): ArrayList<App> {

        val appList = ArrayList<App>()
        appList.add(App(R.drawable.flipkart_icon, "Flipkart", "https://www.flipkart.com/"))
        appList.add(App(R.drawable.amazon_icon, "Amazon", "https://www.amazon.com/"))
        appList.add(App(R.drawable.meesho_logo, "Meesho", "https://www.meesho.com/"))
        appList.add(App(R.drawable.myntra_icon, "Myntra", "https://www.myntra.com/"))

        return appList
    }

    private fun getFoodProducts(): ArrayList<App> {
        // Create a list of products for the Food segment
        val appList = ArrayList<App>()
        appList.add(App(R.drawable.zomato, "Zomato", "https://www.zomato.com/"))
        appList.add(App(R.drawable.swiggy_icon, "Swiggy", "https://www.swiggy.com/"))
        appList.add(App(R.drawable.dominos, "Dominos", "https://pizzaonline.dominos.co.in/"))
        appList.add(App(R.drawable.uber_eats_icon, "Uber Eats", "https://www.ubereats.com/"))
        // Add more products as needed
        return appList
    }

 }
