package com.lucidsoftworksllc.applicationblank.main_activity.repositories

import com.lucidsoftworksllc.applicationblank.main_activity.repositories.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MainActivityApi {

    @GET("query")
    suspend fun getData(
        @Query("symbol") symbol: String?,
        @Query("function") function: String? = "GLOBAL_QUOTE",
        @Query("apikey") apikey: String? = "1BZAP5IO512B6GGM"
    ) : ResponseModel

}
