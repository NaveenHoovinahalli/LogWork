package com.example.mydemosample

import com.example.logwork.*
import retrofit2.Call
import retrofit2.http.*

interface ApiKot {

//    https://docs.google.com/document/d/1phIZpy2-YOncFx0G7YoN2011xw-rrPDVsv9kU9Tscb8/edit

    companion object {
        const val BASE_URL2 = "https://api.helpster.tech/"
         const val path = "v1/staff-requests/26074/"
        const val serverkey = "e945ae028e2355e123cfdf1b4fbb81ad4e5b2ebc"

        const val checkinURL = "v1/staff-requests/26074/clock-in/"
       const val checkoutURL = "v1/staff-requests/26074/clock-out/"
    }


    @POST
    fun logIn(@Body user: User, @Url endPoint : String) : Call<ResponseData>


    @GET("v1/staff-requests/26074/")
    fun getAuthorizedDriver(@Header("Authorization") auth: String?): Call<UserDetails>

    @POST(checkinURL)
    fun clockIn(@Header("Authorization") auth: String?, @Body clockin: ClockIn): Call<ClockSuccess>
//    fun clockIn(@Header("Authorization") auth: String?, @Body clockin: ClockIn, @Url endPoint : String): Call<ClockSuccess>

    @POST
    fun clockOut(@Header("Authorization") auth: String? , @Body clockin: ClockIn , @Url endPoint : String): Call<ClockOutSuccess>

}