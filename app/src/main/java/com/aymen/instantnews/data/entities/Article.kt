package com.aymen.instantnews.data.entities

import java.sql.Timestamp

class Article {
    val author: String? = null

    val title: String? = null

    val description: String? = null

    val url: String? = null

    val publishedAt: Timestamp? = null

    val urlToImage: String? = null

    val source: ArticleSource? = null

    val content: String? = null

    var category: String? = null

    var saveDate: Timestamp? = Timestamp(System.currentTimeMillis())

    override fun toString(): String {
        return "Article{" +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", publishedAt=" + publishedAt +
                ", urlToImage='" + urlToImage + '\'' +
                ", source=" + source +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", saveDate=" + saveDate +
                '}'
    }
}
