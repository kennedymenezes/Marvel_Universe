package com.kennedymenezes.marveluniverse.commons.utils

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.checkConnection(): Boolean{
    val connectivityManager = getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    // In here we return true if network is not null and Network is connected
    if(networkInfo != null && networkInfo.isConnected){
        return true
    }
    return false

}