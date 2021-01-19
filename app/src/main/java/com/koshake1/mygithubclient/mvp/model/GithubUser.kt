package com.koshake1.mygithubclient.mvp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class GithubUser(val login: String) : Parcelable