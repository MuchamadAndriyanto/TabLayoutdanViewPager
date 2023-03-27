package com.example.tampilanwa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.tampilanwa.databinding.ActivityMainBinding
import com.google.android.material.search.SearchView.Behavior

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "TabPage"
        supportActionBar?.elevation = 0.0f

        val adapter = TabAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        val icon_tab = LayoutInflater.from(this).inflate(R.layout.tab_icon, null)

        binding.tabLayout.getTabAt(3)?.customView = icon_tab


    }

    class TabAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {
        private val tabName : Array<String> = arrayOf("Home", "Status", "Profile","Camera")

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> HomeFragment()
            1 -> StatusFragment()
            2 -> ProfileFragment()
            3 -> CameraFragment()
            else -> HomeFragment()
        }

        override fun getCount(): Int = 4
        override fun getPageTitle(position: Int): CharSequence? = tabName.get(position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

