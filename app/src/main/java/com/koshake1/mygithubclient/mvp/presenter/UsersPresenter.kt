package com.koshake1.mygithubclient.mvp.presenter

import com.koshake1.mygithubclient.mvp.model.GithubUser
import com.koshake1.mygithubclient.mvp.model.GithubUsersRepo
import com.koshake1.mygithubclient.mvp.presenter.list.IUserListPresenter
import com.koshake1.mygithubclient.mvp.view.IUsersView
import com.koshake1.mygithubclient.mvp.view.list.IUserItemView
import com.koshake1.mygithubclient.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(private val usersRepo: GithubUsersRepo, private val router: Router) : MvpPresenter<IUsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount(): Int {
            return users.size
        }
    }
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = {
            itemView -> router.navigateTo(Screens.UserScreen(itemView.getLogin()))
        }
    }

    val usersListPresenter = UsersListPresenter()
    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed() : Boolean {
        router.exit()
        return true
    }
}