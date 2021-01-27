package com.koshake1.mygithubclient.mvp.model.repo.retrofit

import com.koshake1.mygithubclient.mvp.model.GithubRepository
import com.koshake1.mygithubclient.mvp.model.GithubUser
import com.koshake1.mygithubclient.mvp.model.api.IDataSource
import com.koshake1.mygithubclient.mvp.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(private val api : IDataSource) : IGithubUsersRepo {
    override fun getUsers(): Single<List<GithubUser>>  = api.getUsers().subscribeOn(Schedulers.io())
}