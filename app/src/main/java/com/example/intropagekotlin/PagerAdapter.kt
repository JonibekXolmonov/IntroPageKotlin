package com.example.intropagekotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.util.ArrayList


class PageAdapter(private val pages: ArrayList<Page>, private val context: Context) :
    PagerAdapter() {
    override fun getCount(): Int {
        return pages.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_page, container, false)

        view.findViewById<ImageView>(R.id.iv_opener).setImageResource(pages[position].image)
        view.findViewById<TextView>(R.id.tv_context).text = pages[position].context
        view.findViewById<TextView>(R.id.tv_description).text = pages[position].description

        (container as ViewPager).addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }
}
