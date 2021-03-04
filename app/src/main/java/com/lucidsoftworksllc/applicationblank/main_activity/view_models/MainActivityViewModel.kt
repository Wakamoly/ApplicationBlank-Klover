package com.lucidsoftworksllc.applicationblank.main_activity.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucidsoftworksllc.applicationblank.main_activity.repositories.MainActivityRepository
import com.lucidsoftworksllc.applicationblank.main_activity.repositories.models.ResponseModel
import com.lucidsoftworksllc.applicationblank.others.DataState
import kotlinx.coroutines.launch

class MainActivityViewModel (
    private val repository : MainActivityRepository
) : ViewModel() {

    private val _data = MutableLiveData<ResponseModel>()
    val data : LiveData<ResponseModel>
        get() = _data

    fun getData(symbol: String) {
        viewModelScope.launch {
            when (val result = repository.getData(symbol)) {
                is DataState.Success -> {
                    _data.value = result.data
                    Log.d("TAG", "getData: ${result.data.globalQuote?.symbol}")
                }
            }
        }
    }

}