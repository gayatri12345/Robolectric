package com.user.indexedrecyclerview

import android.os.Build
import com.user.view.viewmodel.RecyclerViewDataViewModel
import org.junit.Before
import org.junit.runner.RunWith
//import androidx.test.core.app.ApplicationProvider
import com.user.indexedrecyclerview.ui.MainActivity
import org.junit.Test
import org.junit.Assert
import org.robolectric.Robolectric

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class RecyclerViewDataViewModelTest {
    internal lateinit var mActivity: MainActivity
    private lateinit var viewModel: RecyclerViewDataViewModel

    @Before
    fun setUp(){
        mActivity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
        viewModel = RecyclerViewDataViewModel(mActivity.application)
    }

    @Test
    fun init(){
        viewModel.init()
        val value = viewModel.recyclerViewData
        Assert.assertNotNull("RecyclerViewData is not null", value)
    }
}
