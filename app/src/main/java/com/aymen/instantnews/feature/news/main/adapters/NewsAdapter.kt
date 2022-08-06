package com.aymen.instantnews.feature.news.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aymen.instantnews.R
import com.aymen.instantnews.data.entities.Article
import com.aymen.instantnews.databinding.NewsItemBinding
import com.aymen.instantnews.feature.news.main.adapters.NewsAdapter.NewsViewHolder

class NewsAdapter(
    private var articles: List<Article> = mutableListOf(),
    private val navigationFun: (article: Article) -> Unit
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): NewsViewHolder {
        val binding = DataBindingUtil.inflate<NewsItemBinding>(
            LayoutInflater.from(parent.context), R.layout.news_item, parent, false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(newsViewHolder: NewsViewHolder, i: Int) {
        newsViewHolder.binding.news = articles[i]
        newsViewHolder.binding.executePendingBindings()
    }

    override fun getItemCount() = articles.size

    fun setArticles(articles: List<Article>?) {
        articles?.let {
            this.articles = articles
            notifyDataSetChanged()
        }
    }

    inner class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ), View.OnClickListener {
        override fun onClick(v: View) {
            val index = this.adapterPosition
            navigationFun(articles[index])
        }

        init {
            binding.root.setOnClickListener(this)
        }
    }
}
