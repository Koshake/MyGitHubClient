package com.koshake1.mygithubclient.mvp.presenter

import com.koshake1.mygithubclient.CounterNum
import com.koshake1.mygithubclient.mvp.model.CountersModel
import com.koshake1.mygithubclient.mvp.view.MainView

class MainPresenter(private val view: MainView) {
    private val model = CountersModel()

    fun counterClick(id: CounterNum) {
        when (id) {
            CounterNum.FIRST -> {
                view.setButtonText(CounterNum.FIRST, model.next(id.num).toString())
            }
            CounterNum.SECOND -> {
                view.setButtonText(CounterNum.SECOND, model.next(id.num).toString())
            }
            CounterNum.THIRD -> {
                view.setButtonText(CounterNum.THIRD, model.next(id.num).toString())
            }
        }
    }
}