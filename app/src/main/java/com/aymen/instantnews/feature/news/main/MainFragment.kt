package com.aymen.instantnews.feature.news.main

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.aymen.instantnews.R
import com.aymen.instantnews.common.archi.fragment.BaseFragment
import com.aymen.instantnews.common.archi.resources.ResourceState
import com.aymen.instantnews.common.utils.isOnline
import com.aymen.instantnews.data.entities.Category
import com.aymen.instantnews.data.entities.Specification
import com.aymen.instantnews.databinding.FragmentMainBinding
import com.aymen.instantnews.feature.news.main.adapters.NewsAdapter
import com.google.gson.Gson


class MainFragment : BaseFragment() {
    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter {
            binding.root.findNavController().navigate(
                MainFragmentDirections.actionHomeFragmentToDetails(Gson().toJson(it))
            )
        }
    }
    private val specs by lazy {
        val specs = Specification()
        specs.setCategory(Category.GENERAL)
        specs
    }

    lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private var listState: Parcelable? = null

    ///////////////////////////////////////////////////////////////////////////
    // FRAGMENT LIVECYCLE OVERRIDE
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
        initNewsObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNewsRecyclerView()
        initClickEvent()
        initNewsList()
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEW HANDLING
    ///////////////////////////////////////////////////////////////////////////
    private fun initNewsRecyclerView() {
        binding.apply {
            rvNewsPosts.adapter = newsAdapter
            val snapHelper: SnapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(rvNewsPosts)
        }
    }

    private fun initClickEvent() {
        binding.apply {
            tvConnection.setOnClickListener {
                initNewsList()
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // OBSERVERS
    ///////////////////////////////////////////////////////////////////////////
    private fun initNewsObservers() {
        viewModel.observeNewsLiveData().observe(this) { resource ->
            resource?.let { result ->
                if (result.status == ResourceState.SUCCESS) {
                    if (!result.data.isNullOrEmpty()) newsAdapter.setArticles(result.data)
                    else {
                        binding.tvNoNews.visibility = View.VISIBLE
                        binding.rvNewsPosts.visibility = View.GONE
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error : ${result.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                viewModel.newsLiveData.postValue(null)
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // DATA
    ///////////////////////////////////////////////////////////////////////////
    private fun initNewsList() {
        if (requireContext().isOnline()) viewModel.getHeadlinesNews(specs)
        else {
            binding.tvConnection.visibility = View.VISIBLE
            binding.rvNewsPosts.visibility = View.GONE
        }
    }
}
