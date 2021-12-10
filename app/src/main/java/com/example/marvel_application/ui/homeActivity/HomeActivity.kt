package com.example.marvel_application.ui.homeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.marvel_application.R
import com.example.marvel_application.databinding.ActivityHomeBinding
import com.example.marvel_application.util.onNavDestinationSelected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
    }

    override fun onResume() {
        super.onResume()
        initNavBar()
    }

    private fun initNavBar() {
        val navController = findNavController(R.id.fragment_container)

        binding.bubbleTabBar.apply {
            addBubbleListener { id ->
                onNavDestinationSelected(id, navController)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                this.setSelectedWithId(destination.id, false)
            }
        }
    }
}