package com.koshake1.mygithubclient.mvp.presenter

import com.koshake1.mygithubclient.mvp.view.IUserView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserPresenter(private val router: Router) : MvpPresenter<IUserView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}