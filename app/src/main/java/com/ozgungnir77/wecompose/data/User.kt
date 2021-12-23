package com.ozgungnir77.wecompose.data

import androidx.annotation.DrawableRes
import com.ozgungnir77.wecompose.R

class User(
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int
) {
    companion object {
        val Me: User = User("rengwuxian", "扔物线-朱凯", R.drawable.avatar_rengwuxian)
    }
}