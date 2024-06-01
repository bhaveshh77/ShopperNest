package com.myapp.shoppernest.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.myapp.shoppernest.databinding.FragmentSearchPageBinding


class SearchPageFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchPageBinding.inflate(layoutInflater)
    }

    private var searchQuery: String? = null

    companion object {
        private const val ARG_SEARCH_QUERY = "search_query"

        fun newInstance(searchQuery: String): SearchPageFragment {
            val fragment = SearchPageFragment()
            val args = Bundle().apply {
                putString(ARG_SEARCH_QUERY, searchQuery)
            }
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        arguments?.let {
            searchQuery = it.getString(ARG_SEARCH_QUERY)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.webViewClient = WebViewClient()

        true.also { binding.webView.settings.javaScriptEnabled = it }

        binding.webView.settings.setSupportZoom(true)

        searchQuery?.let { binding.webView.loadUrl(it) }

    }

//    fun loadUrl(url: String) {
//        binding.webView.loadUrl(url)
//    }

}