package com.game.pruebataxislibres.ui.main

import android.os.Bundle
import com.game.pruebataxislibres.databinding.ActivityMainBinding
import com.game.pruebataxislibres.utils.mvp.BaseView

class MainActivity : BaseView() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigationView(binding.navigationView)

    }

}


