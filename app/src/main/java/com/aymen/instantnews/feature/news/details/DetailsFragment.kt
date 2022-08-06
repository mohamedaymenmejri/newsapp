package com.aymen.instantnews.feature.news.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.aymen.instantnews.R
import com.aymen.instantnews.common.archi.fragment.BaseFragment
import com.aymen.instantnews.data.entities.Article
import com.aymen.instantnews.databinding.FragmentDetailsBinding
import com.google.gson.Gson

class DetailsFragment : BaseFragment() {

    lateinit var binding: FragmentDetailsBinding
    private var article: Article? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBindingFromArgs()
        initClickEvent()
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEW HANDLING SECTION
    ///////////////////////////////////////////////////////////////////////////
    private fun initBindingFromArgs() {
        article = Gson().fromJson(
            DetailsFragmentArgs.fromBundle(requireArguments()).chosenNews,
            Article::class.java
        )
        binding.news = article
        binding.executePendingBindings()
    }

    private fun initClickEvent() {
        binding.apply {
            backNav.setOnClickListener {
                binding.root.findNavController().navigateUp()
            }
            readMore.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article?.url))
                startActivity(intent)
            }
        }
    }
}
