package com.formaxit.rechargeapp.Network

import com.formaxit.rechargeapp.model.LogIn
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL = " http://apilogin.in/rest/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AppApiService{

    @POST("userLogin")
    fun userLogIn(@Body body: LogIn):Call<String>
}

object AppsApi{

    val retrofitService : AppApiService by lazy { retrofit.create(AppApiService::class.java) }
}