package com.lucidsoftworksllc.applicationblank.main_activity.repositories

import com.lucidsoftworksllc.applicationblank.base.BaseRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MainActivityRepository (
    private val api : MainActivityApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseRepository(dispatcher) {

    suspend fun getData(symbol: String) = safeApiCall { api.getData(symbol) }

}
