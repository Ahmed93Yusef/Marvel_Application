package com.example.marvel_application.util

import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_application.R
import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.response.characters.Thumbnail
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.util.Constant.TAG
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> View.showWhenLoading(state: State<T>?) {
    if (state is State.Loading) {
        this.visibility = VISIBLE
    } else {
        this.visibility = GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> View.showWhenError(state: State<T>?) {
    if (state is State.Error) {
        this.visibility = VISIBLE
    } else {
        this.visibility = GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> View.showWhenSuccess(state: State<T>?) {
    if (state is State.Success) {
        this.visibility = VISIBLE
    } else {
        this.visibility = GONE
    }
}

@BindingAdapter(value = ["app:showWhenSearch"])
fun <T> View.showWhenSearch(state: State<T>?) {
    if (state is State.Success || state is State.Loading || state is State.Error) {
        this.visibility = GONE
    } else {
        this.visibility = VISIBLE
    }
}

@BindingAdapter(value = ["app:ImageUrl"])
fun ImageView.setImageUrl(urls: Thumbnail?) {
    if (urls != null) {
        val httpString = urls.path?.subSequence(0,4)
        val httpPath = urls.path?.subSequence(4,urls.path.length)
    val url = "${httpString}s${httpPath}.${urls.extension}"
        Log.i(TAG, "setImageUrl: ${urls.path} -- $httpPath --- $httpPath")
        GlideApp.with(context)
            .load(url)
            .placeholder(R.drawable.progress_animation)
            .error(R.drawable.ic_baseline_error_outline_24)
            .timeout(10000)
            .into(this)
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> RecyclerView.setRecyclerView(items: List<T>?) {
    if (items != null) {
        (this.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (this.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}
