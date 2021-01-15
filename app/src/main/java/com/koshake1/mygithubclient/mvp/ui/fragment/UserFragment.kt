package com.koshake1.mygithubclient.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.koshake1.mygithubclient.App
import com.koshake1.mygithubclient.R
import com.koshake1.mygithubclient.mvp.model.GithubUsersRepo
import com.koshake1.mygithubclient.mvp.presenter.UserPresenter
import com.koshake1.mygithubclient.mvp.presenter.UsersPresenter
import com.koshake1.mygithubclient.mvp.ui.BackButtonListener
import com.koshake1.mygithubclient.mvp.ui.adapter.UsersRVAdapter
import com.koshake1.mygithubclient.mvp.view.IUserView
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(private val login: String) : MvpAppCompatFragment(), IUserView,
    BackButtonListener {
    companion object {
        fun newInstance(login: String) = UserFragment(login)
    }

    private val userPresenter by moxyPresenter {
        UserPresenter(App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_user, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLoginText(login)
    }

    override fun backPressed() = userPresenter.backPressed()

    override fun setLoginText(text: String) {
        loginText.text = text
    }
}