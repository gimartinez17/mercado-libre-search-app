package com.example.mercadolibresearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mercadolibresearch.R
import com.example.mercadolibresearch.databinding.ActivityMainBinding
import com.example.mercadolibresearch.ui.fragment.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = SearchFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(fragment.toString())
                .commitAllowingStateLoss()
        }
    }
}