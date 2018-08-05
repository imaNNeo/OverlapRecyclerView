package com.neo.overlaprecyclerview

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.RoundImageViewHolder>() {

    var mItems = mutableListOf<String>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RoundImageViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.image_item, viewGroup, false)

        return RoundImageViewHolder(view)
    }

    override fun getItemCount() = mItems.size

    override fun onBindViewHolder(vh: RoundImageViewHolder, pos: Int) {
        vh.refresh(mItems[pos], pos == mItems.size - 1)
    }

    fun resetItems(items: List<String>) {
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }


    class RoundImageViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        val ivImage = v.findViewById<ImageView>(R.id.iv_image)

        fun refresh(imageUrl: String, isLastItem: Boolean) {

            val curveRadius = v.resources.getDimensionPixelSize(R.dimen.curve_radius)
            val radius = if (isLastItem) 0 else curveRadius

            GlideApp.with(v.context)
                    .load(imageUrl)
                    .transform(CircleCurveTransformation(radius))
                    .into(ivImage)
        }
    }
}