package com.example.logwork

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydemosample.RequestServer

class HeroesViewModelKot(val requestServer: RequestServer) : ViewModel() {
//    private var heroList = MutableLiveData<List<Hero>> ()
//     var myPosition = MutableLiveData<String> ()
//    val heroes: LiveData<List<Hero>>
//        get() = this.heroList

    fun fetchData() {
        requestServer.login()
    }



    fun clockUser() {
        requestServer.clockOUTUser()
//        requestServer.getUserDetails()
//        requestServer.clockUser(it)
    }
}