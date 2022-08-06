package com.aymen.instantnews.test

import android.os.Build.VERSION_CODES.Q
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aymen.instantnews.data.entities.Category
import com.aymen.instantnews.data.entities.Specification
import com.aymen.instantnews.di.DaggerApplicationComponentTest
import com.aymen.instantnews.usecase.HeadlinesNewsUseCaseTest
import com.google.common.truth.Truth
import kotlinx.coroutines.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Q])
open class UseCaseTest {

    @Inject
    lateinit var headlinesNewsUseCase: HeadlinesNewsUseCaseTest

    @Before
    fun setUp() {
        val component = DaggerApplicationComponentTest.factory().create(
            ApplicationProvider.getApplicationContext()
        )
        component.inject(this)
    }

    @Test
    fun `assert that web service is working with a no empty response`() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            Truth.assertWithMessage("service error for retrieval")
                .that("error")
                .isEqualTo("no error")
        }

        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler) {
            try {
                val specs = Specification()
                specs.setCategory(Category.GENERAL)
                val userAsync = async { headlinesNewsUseCase.execute(specs) }
                val data = userAsync.await()

                Log.e("Test", "${data?.articles?.size?.toString()}")

                Truth.assertWithMessage("there is a data !!")
                    .that(data?.articles)
                    .isNotEmpty()

            } catch (e: Exception) {
                Truth.assertWithMessage("response for retrieval error")
                    .that("error")
                    .isEqualTo("no error")
            }
        }
    }
}
