package com.indialone.viewpagerdemotl.verticalviewpager

import android.animation.ArgbEvaluator
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.indialone.viewpagerdemotl.R


class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter : ViewPager2Adapter
    private var colors: IntArray? = null
    private var argbEvaluator = ArgbEvaluator()


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)

        val list = arrayListOf<Page>(
            Page(resources.getColor(R.color.color1),"1"),
            Page(resources.getColor(R.color.color2),"2"),
            Page(resources.getColor(R.color.color3),"3"),
            Page(resources.getColor(R.color.color4),"4"),
        )

        adapter = ViewPager2Adapter(list)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        viewPager.setPageTransformer(ZoomAnimationViewPager2())

    }

}