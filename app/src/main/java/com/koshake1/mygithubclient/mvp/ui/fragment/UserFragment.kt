package com.koshake1.mygithubclient.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.koshake1.mygithubclient.ApiHolder
import com.koshake1.mygithubclient.App
import com.koshake1.mygithubclient.R
import com.koshake1.mygithubclient.mvp.model.GithubUser
import com.koshake1.mygithubclient.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo
import com.koshake1.mygithubclient.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import com.koshake1.mygithubclient.mvp.presenter.UserPresenter
import com.koshake1.mygithubclient.mvp.presenter.UsersPresenter
import com.koshake1.mygithubclient.mvp.ui.BackButtonListener
import com.koshake1.mygithubclient.mvp.ui.GlideImageLoader
import com.koshake1.mygithubclient.mvp.ui.adapter.UserAdapter
import com.koshake1.mygithubclient.mvp.ui.adapter.UsersRVAdapter
import com.koshake1.mygithubclient.mvp.view.IUserView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(private val user: GithubUser) : MvpAppCompatFragment(), IUserView,
    BackButtonListener {
    companion object {

        fun newInstance(user: GithubUser) = UserFragment(user)
    }

    private var adapter: UserAdapter? = null

    private val userPresenter by moxyPresenter {
        UserPresenter(AndroidSchedulers.mainThread(),
            RetrofitGithubRepositoriesRepo(ApiHolder().api),
            App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_user, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPresenter.setUser(user)
    }

    override fun backPressed() = userPresenter.backPressed()

    override fun setTitle(text: String) {
        userToolbar.title = text
    }

    override fun init() {
        mainRecycler.layoutManager = LinearLayoutManager(context)
        adapter = UserAdapter(userPresenter.reposListPresenter)
        mainRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}