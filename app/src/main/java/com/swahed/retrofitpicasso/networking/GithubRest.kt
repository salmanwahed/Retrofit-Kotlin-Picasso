package com.swahed.retrofitpicasso.networking

import com.swahed.retrofitpicasso.model.GithubUser
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by salman on 10/16/18
 */
interface GithubRest {
    @get:GET("users/salmanwahed/followers")
    val allFollowers: Call<List<GithubUser>>

    @get:GET("users/salmanwahed/following")
    val allFollowing: Call<List<GithubUser>>
}
