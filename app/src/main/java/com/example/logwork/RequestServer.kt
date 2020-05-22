package com.example.mydemosample

import android.util.Log
import com.example.logwork.*
import com.example.mydemosample.ApiKot.Companion.checkinURL
import com.example.mydemosample.ApiKot.Companion.checkoutURL
import com.example.mydemosample.ApiKot.Companion.serverkey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestServer {

     fun login() {
        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        val api = retrofit.create(ApiKot::class.java)
        val user = User ("+6281313272005","alexander")
         val call = api.logIn(user,"v1/auth/login/")
            call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                Log.d("NaveenTesting", "esponse"+response.body())
                 var responseData = response.body()
                   responseData?.key?.let { getUserDetails(it)
                       Log.d("NaveenTesting", "sending:::"+it)
                   }
            }
            override fun onFailure(
                call: Call<ResponseData>,
                t: Throwable
            ) {
            }

        })
    }

    fun getUserDetails(key : String ) {
        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        val api = retrofit.create(ApiKot::class.java)
        val user = User ("+6281313272005","alexander")
        val call = api.getAuthorizedDriver("token "+serverkey)
        call.enqueue(object : Callback<UserDetails> {

            override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                Log.d("NaveenTesting", "esponse"+response.body())
                clockInUser("")
            }

            override fun onFailure(
                call: Call<UserDetails>,
                t: Throwable
            ) {
            }


        })
    }

    fun clockInUser(it: String) {

        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        val api = retrofit.create(ApiKot::class.java)
        var clockin = ClockIn("-6.2446691", "106.8779625")
        val call = api.clockIn("token "+ serverkey , clockin)
        call.enqueue(object : Callback<ClockSuccess> {

            override fun onResponse(call: Call<ClockSuccess>, response: Response<ClockSuccess>) {
                Log.d("NaveenTesting", "INerror::"+response.errorBody().toString())
                Log.d("NaveenTesting", "INIsSuccess::"+response.code())
                Log.d("NaveenTesting", "INResponse"+response.body())
                Log.d("NaveenTesting", "INerror::"+response.message())
            }

            override fun onFailure(
                call: Call<ClockSuccess>,
                t: Throwable
            ) {
                Log.d("NaveenTesting", "INerroresponse"+t.message)
            }


        })
    }

    fun clockOUTUser() {

        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        val api = retrofit.create(ApiKot::class.java)
        var clockin = ClockIn("-6.2446691", "106.8779625")
        val call = api.clockOut("token "+serverkey , clockin , checkoutURL)
        call.enqueue(object : Callback<ClockOutSuccess> {

            override fun onResponse(call: Call<ClockOutSuccess>, response: Response<ClockOutSuccess>) {
                Log.d("NaveenTesting", "OUTerror::"+response.errorBody().toString())
                Log.d("NaveenTesting", "OUTIsSuccess::"+response.code())
                Log.d("NaveenTesting", "OUTResponse"+response.body())
                Log.d("NaveenTesting", "OUTMessage"+response.message())
            }

            override fun onFailure(
                call: Call<ClockOutSuccess>,
                t: Throwable
            ) {
                Log.d("NaveenTesting", "OUTerroresponse"+t.message)
            }


        })
    }

}