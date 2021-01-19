package com.koshake1.mygithubclient.navigation

import com.koshake1.mygithubclient.mvp.ui.fragment.UserFragment
import com.koshake1.mygithubclient.mvp.ui.fragment.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class UserScreen(private val login: String) : SupportAppScreen() {
        override fun getFragment() = UserFragment.newInstance(login)
    }
}