package com.indialone.viewpagerdemotl.verticalviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.indialone.viewpagerdemotl.R

class ViewPager2Adapter(
    private val list: ArrayList<Page>
) : RecyclerView.Adapter<ViewPager2Adapter.ViewPager2ViewHolder>() {
    class ViewPager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.tv)
        val layout : ConstraintLayout = itemView.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewPager2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPager2ViewHolder, position: Int) {
        holder.tv.text = list[position].text
        holder.layout.setBackgroundColor(list[position].color)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}