package com.aymen.instantnews.feature.news

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aymen.instantnews.R
import com.aymen.instantnews.common.archi.activity.BaseActivity
import com.aymen.instantnews.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override val defineLayoutBinding: () -> View
        get() = {
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            view
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavController()
        ViewCompat.setOnApplyWindowInsetsListener(binding.navHostFragmentContainer) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply the insets as a margin to the view. Here the system is setting
            // only the bottom, left, and right dimensions, but apply whichever insets are
            // appropriate to your layout. You can also update the view padding
            // if that's more appropriate.
            val menuLayoutParams =
                binding.navHostFragmentContainer.layoutParams as FrameLayout.LayoutParams
            menuLayoutParams.marginEnd = 0
            menuLayoutParams.marginStart = 0
            menuLayoutParams.topMargin = -insets.top
            menuLayoutParams.bottomMargin = insets.bottom
            binding.navHostFragmentContainer.layoutParams = menuLayoutParams

            // Return CONSUMED if you don't want want the window insets to keep being
            // passed down to descendant views.
            WindowInsetsCompat.CONSUMED
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            navController.navigateUp()
        else super.onBackPressed()
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEW INITIALIZER
    ///////////////////////////////////////////////////////////////////////////
    private fun initNavController() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
    }
}
