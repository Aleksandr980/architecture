package com.example.m16_architecture.data

import com.example.m16_architecture.entity.UsefulActivity
import com.example.m16_architecture.utils.Constants.Companion.API_KEY
import com.example.m16_architecture.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject


class Api  @Inject constructor() {
    private val retrofit = Retrofit
        .Builder()
        .client(
            OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                }).build()
        )
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val usefulActivityApi: UsefulActivityApi = retrofit
        .create(UsefulActivityApi::class.java)

   private  interface UsefulActivityApi {
        @GET(API_KEY)
        suspend fun getActivity(): UsefulActivityDto
    }

   suspend fun getNewActivity(): UsefulActivity {
        return usefulActivityApi.getActivity()
    }
}
