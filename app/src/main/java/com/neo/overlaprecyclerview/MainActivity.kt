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
                "https://picsum.photos/400/400?image=1",
                "https://picsum.photos/400/400?image=2",
                "https://picsum.photos/400/400?image=3",
                "https://picsum.photos/400/400?image=4",
                "https://picsum.photos/400/400?image=5",
                "https://picsum.photos/400/400?image=6",
                "https://picsum.photos/400/400?image=7",
                "https://picsum.photos/400/400?image=8",
                "https://picsum.photos/400/400?image=9",
                "https://picsum.photos/400/400?image=10"
        )
        mAdapter.resetItems(items)

    }

}
