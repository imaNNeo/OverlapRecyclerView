package com.neo.overlaprecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_item.*

class MainActivity : AppCompatActivity() {


    val mAdapter = ImagesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_content.adapter = mAdapter
        rv_content.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val overlapRadius = resources.getDimensionPixelSize(R.dimen.overlap_radius)
        rv_content.addItemDecoration(OverlapDecoration(overlapRadius))

        val items = listOf(
                "https://picsum.photos/500/500?image=10",
                "https://picsum.photos/500/500?image=20",
                "https://picsum.photos/500/500?image=30",
                "https://picsum.photos/500/500?image=40",
                "https://picsum.photos/500/500?image=50",
                "https://picsum.photos/500/500?image=60",
                "https://picsum.photos/500/500?image=70",
                "https://picsum.photos/500/500?image=80",
                "https://picsum.photos/500/500?image=90",
                "https://picsum.photos/500/500?image=1"
        )
        mAdapter.resetItems(items)




        val curveRadius = resources.getDimensionPixelSize(R.dimen.curve_radius)
        GlideApp.with(this)
                .load(items[0])
                .transform(CircleCurveTransformation(curveRadius))
                .into(iv_sample1)



        GlideApp.with(this)
                .load(items[3])
                .transform(CircleCurveTransformation(curveRadius * 3))
                .into(iv_sample2)
    }

}
