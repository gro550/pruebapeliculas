package com.game.pruebataxislibres.utils.mvp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.game.pruebataxislibres.R
import com.game.pruebataxislibres.ui.fragment.map.MapFragment
import com.game.pruebataxislibres.ui.fragment.movies.MoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

open class BaseView : AppCompatActivity() {
    private val firstFragment = MoviesFragment()
    private val secondFragment = MapFragment()

    fun setNavigationView(menu: BottomNavigationView) {
        setCurrentFragment(firstFragment)
        menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nvMap -> setCurrentFragment(secondFragment)
                R.id.nvMovies -> setCurrentFragment(firstFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentMain, fragment)
            commit()
        }
    }


}