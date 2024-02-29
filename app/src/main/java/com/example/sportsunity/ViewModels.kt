package com.example.sportsunity

import androidx.navigation.NavController

interface MainActivityCallback{
    fun createAccount(email: String,password: String)
    fun login(email:String,password:String,navController: NavController)
}