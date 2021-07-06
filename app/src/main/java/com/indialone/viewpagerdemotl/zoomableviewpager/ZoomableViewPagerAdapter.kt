package com.indialone.viewpagerdemotl.zoomableviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.viewpagerdemotl.R

class ZoomableViewPagerAdapter(
    private val list: ArrayList<BookEntity>
) : RecyclerView.Adapter<ZoomableViewPagerAdapter.ZoomableViewPagerViewHolder>() {
    class ZoomableViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.iv_book)
        private val title: TextView = itemView.findViewById(R.id.tv_title)

        fun bind(book: BookEntity) {
            title.text = book.title
            Glide.with(itemView.context)
                .load(book.image)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZoomableViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_item_layout, parent, false)
        return ZoomableViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZoomableViewPagerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}