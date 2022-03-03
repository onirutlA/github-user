package com.onirutla.githubuser.data.remote.response

import com.onirutla.githubuser.data.local.entity.UserEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(

    @Json(name = "following_url")
    val followingUrl: String? = null,

    @Json(name = "login")
    val username: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "blog")
    val blog: String? = null,

    @Json(name = "company")
    val company: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "public_repos")
    val publicRepos: Int? = null,

    @Json(name = "followers_url")
    val followersUrl: String? = null,

    @Json(name = "public_gists")
    val publicGists: Int? = null,

    @Json(name = "followers")
    val followers: Int? = null,

    @Json(name = "avatar_url")
    val avatarUrl: String? = null,

    @Json(name = "following")
    val following: Int? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "location")
    val location: String? = null,
)

fun UserResponse.toEntity() = UserEntity(
    id = id ?: 0,
    username = username.orEmpty(),
    name = name.orEmpty(),
    type = type.orEmpty(),
    followers = followers ?: 0,
    following = following ?: 0,
    publicRepos = publicRepos ?: 0,
    followersUrl = followersUrl.orEmpty(),
    followingUrl = followingUrl.orEmpty(),
    avatarUrl = avatarUrl.orEmpty(),
    isFavorite = false,
    company = company.orEmpty(),
    location = location.orEmpty()
)
