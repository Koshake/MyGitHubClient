package com.koshake1.mygithubclient.mvp.model.repo.retrofit

import com.koshake1.mygithubclient.mvp.model.GithubRepository
import com.koshake1.mygithubclient.mvp.model.GithubUser
import com.koshake1.mygithubclient.mvp.model.api.IDataSource
import com.koshake1.mygithubclient.mvp.model.repo.IGithubRepositoriesRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubRepositoriesRepo(private val api : IDataSource) : IGithubRepositoriesRepo {
    override fun getRepos(user: GithubUser): Single<List<GithubRepository>> = api.getRepos(user.reposUrl.toString()).subscribeOn(
        Schedulers.io())
}