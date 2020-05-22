package com.example.logwork


data class User(val username: String, val password:String)
data class ResponseData(val key: String)
data class UserDetails(val id: String, val title: String)
data class ClockIn(val latitude:String,val longitude: String)
data class Timesheet(val id:String,val clock_in_time: String )
data class ClockSuccess(val id:String,val clock_in_time: String)
data class ClockAlreadySuccess(val code:String, val detail:String)
data class ClockOutSuccess(val timesheet: Timesheet, val require_feedback: String)