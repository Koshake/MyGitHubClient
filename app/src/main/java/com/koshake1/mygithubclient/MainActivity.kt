package com.koshake1.mygithubclient

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.koshake1.mygithubclient.mvp.presenter.MainPresenter
import com.koshake1.mygithubclient.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener {
            when (it.id) {
                R.id.btn_counter1 -> {
                    presenter.counterClick(CounterNum.FIRST)
                }
                R.id.btn_counter2  -> {
                    presenter.counterClick(CounterNum.SECOND)
                }
                R.id.btn_counter3  -> {
                    presenter.counterClick(CounterNum.THIRD)
                }
            }
        }

        btn_counter1.setOnClickListener(listener)
        btn_counter2.setOnClickListener(listener)
        btn_counter3.setOnClickListener(listener)
    }

    override fun setButtonText(index: CounterNum, text: String) {
        when (index) {
            CounterNum.FIRST -> btn_counter1.text = text
            CounterNum.SECOND -> btn_counter2.text = text
            CounterNum.THIRD -> btn_counter3.text = text
        }
    }
}