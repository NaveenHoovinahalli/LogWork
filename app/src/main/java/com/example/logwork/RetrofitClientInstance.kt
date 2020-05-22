package com.example.mydemosample

import com.example.mydemosample.ApiKot.Companion.BASE_URL2
import com.example.mydemosample.ApiKot.Companion.serverkey
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitClientInstance {


//
//    var headerAuthorizationInterceptor = Interceptor { chain ->
//        var request = chain.request()
//        val headers =
//            request.headers().newBuilder().add("Authorization", "token"+serverkey).build()
//        request = request.newBuilder().headers(headers).build()
//        chain.proceed(request)
//    }
//
//    var clientBuilder = OkHttpClient.Builder().addInterceptor(headerAuthorizationInterceptor)
//
//
//
////    clientBuilder.addInterceptor(headerAuthorizationInterceptor);


    fun getRetrofitInstance(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
