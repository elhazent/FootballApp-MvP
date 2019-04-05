package com.elhazent.picodiploma.footballproject.mvp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.elhazent.picodiploma.footballproject.R
import com.elhazent.picodiploma.footballproject.mvp.view.fragment.LastFragment
import com.elhazent.picodiploma.footballproject.mvp.view.fragment.NextFragment
import kotlinx.android.synthetic.main.activity_football.*

class FootballActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)

        tablayout.addTab(tablayout.newTab().setText(R.string.lastmatch))
        tablayout.addTab(tablayout.newTab().setText(R.string.nextmatch))
        val adapter = CustomAdapter(supportFragmentManager)
        pager.adapter = adapter
        pager.setOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))
        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                pager.currentItem = p0!!.position
            }
        })

    }
}

class CustomAdapter(supportFragmentManager: FragmentManager?): FragmentStatePagerAdapter(supportFragmentManager) {

    private val fragmentList = listOf<Fragment>(LastFragment(),NextFragment())
    override fun getItem(p0: Int): Fragment = fragmentList[p0]

    override fun getCount(): Int = fragmentList.size

}
