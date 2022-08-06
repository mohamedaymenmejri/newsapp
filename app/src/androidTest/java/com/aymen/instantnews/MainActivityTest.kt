package com.aymen.instantnews

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.aymen.instantnews.feature.news.MainActivity
import com.aymen.instantnews.feature.news.main.MainFragment
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

   private var newsHomeActivity: MainActivity? = null

    @Before
    fun setUp() {
        newsHomeActivity = activityTestRule.activity
    }

    @Test
    fun test_MainActivity_is_launched_first() {
        val view: View? = newsHomeActivity?.findViewById(R.id.nav_host_fragment_container)
        assertWithMessage("MainActivity is launched first")
            .that(view)
            .isNotNull()
    }

    @Test
    fun check_that_navController_is_not_null() {
        val navController: NavController? = newsHomeActivity?.navController
        assertWithMessage("navController initialized successfully")
            .that(navController)
            .isNotNull()
    }

    @Test
    fun check_that_navController_set_mainFragment_first() {
        val navController: NavController? = newsHomeActivity?.navController
        assertWithMessage("navController initialized successfully")
            .that(navController)
            .isNotNull()
        assertWithMessage("navController initialized MainFragment first on stack")
            .that(navController?.currentDestination?.id)
            .isEqualTo(R.id.mainFragment)
    }

    @Test
    fun check_that_recyclerview_is_set_in_homeFragment() {
        val navHostFragment: Fragment? =
            newsHomeActivity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment)
        assertWithMessage("MainFragment initialized successfully")
            .that(navHostFragment?.childFragmentManager?.fragments?.get(0))
            .isNotNull()
        val newsFavFragment =
            navHostFragment?.childFragmentManager?.fragments?.get(0) as? MainFragment
        getInstrumentation().waitForIdleSync()
        val recyclerView =
            newsFavFragment?.view?.findViewById<RecyclerView>(R.id.rv_news_posts)
        assertWithMessage("recyclerview initialized successfully")
            .that(recyclerView)
            .isNotNull()
    }

    @Test
    fun check_that_recyclerview_item_list_isNotEmpty() {
        val navHostFragment: Fragment? =
            newsHomeActivity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment)
        assertWithMessage("MainFragment initialized successfully")
            .that(navHostFragment?.childFragmentManager?.fragments?.get(0))
            .isNotNull()
        val newsFavFragment =
            navHostFragment?.childFragmentManager?.fragments?.get(0) as? MainFragment
        getInstrumentation().waitForIdleSync()
        val recyclerView =
            newsFavFragment?.view?.findViewById<RecyclerView>(R.id.rv_news_posts)
        assertThat(recyclerView).isNotNull()
        assertWithMessage("recyclerview initialized successfully")
            .that(recyclerView)
            .isNotNull()
        Thread.sleep(5000)
        assertWithMessage("recyclerview item list is not empty")
            .that(recyclerView?.adapter?.itemCount)
            .isNotEqualTo(0)
    }

    @Test
    fun check_click_item_recyclerview_navigate_to_detailFragment() {
        val navHostFragment: Fragment? =
            newsHomeActivity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment)
        assertWithMessage("MainFragment initialized successfully")
            .that(navHostFragment?.childFragmentManager?.fragments?.get(0))
            .isNotNull()
        val newsFavFragment =
            navHostFragment?.childFragmentManager?.fragments?.get(0) as? MainFragment
        getInstrumentation().waitForIdleSync()
        val recyclerView =
            newsFavFragment?.view?.findViewById<RecyclerView>(R.id.rv_news_posts)
        assertWithMessage("recyclerview initialized successfully")
            .that(recyclerView)
            .isNotNull()
        Thread.sleep(5000)
        assertWithMessage("recyclerview item list is not empty")
            .that(recyclerView?.adapter?.itemCount)
            .isNotEqualTo(0)
        if ((recyclerView?.adapter?.itemCount ?: 0) > 0) {
            onView(withId(R.id.rv_news_posts)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
            Thread.sleep(500)
            val navController: NavController? = newsHomeActivity?.navController
            assertWithMessage("navController initialized successfully")
                .that(navController)
                .isNotNull()
            assertWithMessage("navController initialized detailsFragment first on stack")
                .that(navController?.currentDestination?.id)
                .isEqualTo(R.id.detailsFragment)
        }
    }

    @After
    fun tearDown() {
        newsHomeActivity = null
    }
}
