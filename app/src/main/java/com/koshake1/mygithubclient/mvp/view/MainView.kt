package com.koshake1.mygithubclient.mvp.view

import com.koshake1.mygithubclient.CounterNum

interface MainView {
    fun setButtonText(index : CounterNum, text : String)
}