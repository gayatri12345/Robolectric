package com.user.indexedrecyclerview

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import com.user.indexedrecyclerview.ui.MainActivity
import com.user.view.viewmodel.RecyclerViewDataViewModel
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class MainActivityTest {

    internal lateinit var activity: MainActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    @Throws(Exception::class)
    fun checkActivityNotNull() {
        assertNotNull("Activity is null",activity)
    }

    @Test
    @Throws(Exception::class)
    fun checkIfViewModelIsNull(){
        //expected
        val expectedDataViewModel = ViewModelProviders.of(activity).get(RecyclerViewDataViewModel::class.java)

        //actual
        val actualDataViewModel = activity.recyclerViewDataViewModel

        //check
        assertTrue(expectedDataViewModel.equals(actualDataViewModel))
    }
}