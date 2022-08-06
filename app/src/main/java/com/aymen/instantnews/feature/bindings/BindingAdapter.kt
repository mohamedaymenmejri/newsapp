package com.aymen.instantnews.feature.bindings

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.aymen.instantnews.R
import com.aymen.instantnews.common.utils.getElapsedTime
import com.bumptech.glide.Glide
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:url")
fun loadThumbnailImage(imageView: ImageView, url: String?) {
    Glide.with(imageView)
        .load(url)
        .placeholder(ContextCompat.getDrawable(imageView.context, R.color.cardBackground))
        .into(imageView)
}

@BindingAdapter("app:sourceName", "app:dateTime")
fun getSourceAndTime(textView: TextView, sourceName: String, dateTime: Timestamp) {
    textView.text = sourceName + " • " + dateTime.time.getElapsedTime()
}

@BindingAdapter("app:dateToFormat")
fun formatDateForDetails(textView: TextView, date: Timestamp) {
    val format = SimpleDateFormat("dd MMM yyyy, hh:mm aaa", Locale.getDefault())
    textView.text = format.format(Date(date.time))
}
