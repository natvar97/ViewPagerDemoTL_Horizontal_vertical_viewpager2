package com.indialone.viewpagerdemotl.zoomableviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.indialone.viewpagerdemotl.R
import java.lang.Math.abs

class ZoomableActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager2
    private lateinit var adapter: ZoomableViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoomable)

        viewpager = findViewById(R.id.viewpager_horizontal)

        adapter = ZoomableViewPagerAdapter(getBookList())
        viewpager.adapter = adapter
//        viewpager.setPageTransformer(ZoomAnimationViewPager2())
        viewpager.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * abs(position))
        }
        viewpager.setPageTransformer(pageTransformer)

        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewpager.addItemDecoration(itemDecoration)

    }

    private fun getBookList(): ArrayList<BookEntity> {
        return arrayListOf<BookEntity>(
            BookEntity(R.drawable.big_little_lies_by_liane_moriarty, "Big Little Lies", ""),
            BookEntity(R.drawable.gone_girl_by_gillian_flunn, "Gone Girl", ""),
            BookEntity(
                R.drawable.img_and_then_there_were_none_by_agatha_christie,
                "And Then There were None ",
                ""
            ),
            BookEntity(R.drawable.in_the_woods_byu_tana_french, "In the Woods", ""),
            BookEntity(R.drawable.rebecca_by_daphne_du_maurier, "Rebecca", ""),
            BookEntity(R.drawable.the_big_sleep_by_raymond_chandler, "The Big Sleep", ""),
            BookEntity(R.drawable.in_cold_blood_by_truman_capote, "In Cold Blood", ""),
            BookEntity(R.drawable.the_da_vinci_code_by_dan_brown, "The Da Vinci Code", ""),
            BookEntity(
                R.drawable.the_daughter_of_time_by_josephine_tey,
                "The Daughter of Time",
                ""
            ),
            BookEntity(
                R.drawable.the_hound_of_the_baskervilles_by_sir_arthur_conan_doyle,
                "The Hound of The BaskerVilles",
                ""
            ),
        )
    }

}