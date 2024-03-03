package com.example.sportsunity.SharedViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private var topBar ="HOME"
    fun getTopBar(): String{
        return topBar
    }
    fun setTopBar(TopBar:String){
        topBar = TopBar
    }

}