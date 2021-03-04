package com.lucidsoftworksllc.applicationblank.others


import com.lucidsoftworksllc.applicationblank.BuildConfig
import com.lucidsoftworksllc.applicationblank.others.Constants.baseUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    fun<Api> buildApi(
        api: Class<Api>
    ): Api{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
                .client(OkHttpClient.Builder()
                    .addInterceptor{chain ->
                        chain.proceed(chain.request().newBuilder().build())
                    }.also { client ->
                    if(BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
                )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}