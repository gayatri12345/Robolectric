package com.user.indexedrecyclerview

import android.os.Build
import androidx.lifecycle.MutableLiveData
import com.user.indexedrecyclerview.ui.MainActivity
import com.user.repositories.RecyclerViewDataRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.InputStream
import java.util.*

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class RecyclerViewDataRepositoryTest   {
    internal lateinit var mActivity: MainActivity
    private var recyclerViewDataList: List<RecyclerViewDataModel> = ArrayList()
    private var sortrecyclerViewDataList: List<RecyclerViewDataModel> = ArrayList()

    @Before
    fun setUp(){
        mActivity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun setData(){
        recyclerViewDataList = mActivity.loadJsonData(R.raw.dummy_data)
        Assert.assertNotNull("Recycler Data list not null",recyclerViewDataList)
        val data = MutableLiveData<List<RecyclerViewDataModel>>()
        data.value = recyclerViewDataList
        Assert.assertNotNull("Data not null",data.value)

    }

    @Test
    fun SortTest(){
        sortrecyclerViewDataList= recyclerViewDataList.sortedBy { it.title }
        Assert.assertEquals(recyclerViewDataList, sortrecyclerViewDataList)
    }
}
