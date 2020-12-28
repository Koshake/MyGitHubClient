package com.koshake1.mygithubclient.mvp.model

class CountersModel {
    private val countersList = mutableListOf(0, 0, 0)

    private fun getCurrent(index: Int) : Int {
        return countersList[index]
    }

    fun next(index: Int) : Int {
        countersList[index]++
        return getCurrent(index)
    }

    fun set(index: Int, value: Int) {
        countersList[index] = value
    }
}