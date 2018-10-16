package com.swahed.retrofitpicasso.model

import com.google.gson.annotations.SerializedName

/**
 * Created by salman on 10/16/18
 */

data class GithubUser(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avater_url") val imageUrl: String,
    @SerializedName("gravater_id") val gravaterId: String,
    @SerializedName("url") val apiUrl: String,
    @SerializedName("html_url") val profileUrl: String,
    @SerializedName("followers_url") val followersUrl: String,
    @SerializedName("following_url") val followingUrl: String,
    @SerializedName("gists_url") val gistsUrl: String,
    @SerializedName("starred_url") val starredUrl: String,
    @SerializedName("subscriptions_url") val subscriptionsUrl: String,
    @SerializedName("organizations_url") val organizationUrl: String,
    @SerializedName("repos_url") val reposUrl: String,
    @SerializedName("events_url") val eventsUrl: String,
    @SerializedName("received_events_url") val receivedEventsUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("site_admin") val siteAdmin: Boolean
)