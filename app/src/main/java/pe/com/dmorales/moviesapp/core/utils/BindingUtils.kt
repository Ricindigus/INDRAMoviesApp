package pe.com.dmorales.moviesapp.core.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import pe.com.dmorales.moviesapp.R

@BindingAdapter("setImageFromURL")
fun ImageView.setImageFromURL(urlImage: String?){
    urlImage?.let {
        val  options : RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
        Glide.with(this.rootView.context).load(it).apply(options).into(this)
    }
}


@BindingAdapter("enableButton")
fun MaterialButton.setButtonEnabled(value: Boolean?){
    value?.let { enable ->
        if (enable){
            isEnabled = true
            alpha = 1.0F
        }else{
            isEnabled = false
            alpha = 0.5F
        }
    }
}

@BindingAdapter("popularity")
fun MaterialTextView.setPopularity(popularity: String?){
    popularity?.also {
        text = resources.getString(R.string.popularity, popularity)
    }
}

@BindingAdapter("voteAverage")
fun MaterialTextView.setVoteAverage(voteAverage: String?){
    voteAverage?.also {
        text = resources.getString(R.string.vote_average, voteAverage)
    }
}

@BindingAdapter("voteCount")
fun MaterialTextView.setVoteCount(voteCount: String?){
    voteCount?.also {
        text = resources.getString(R.string.vote_count, voteCount)
    }
}

@BindingAdapter("isVisibleView")
fun View.setVisibleView(value: Boolean?) {
    value?.let { visible ->
        visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
}

@BindingAdapter("isShowView")
fun View.setShowView(value: Boolean?) {
    value?.let { visible ->
        visibility = if (visible) View.VISIBLE else View.GONE
    }
}