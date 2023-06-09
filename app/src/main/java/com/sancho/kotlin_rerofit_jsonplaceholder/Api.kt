package com.sancho.kotlin_rerofit_jsonplaceholder

import com.sancho.kotlin_rerofit_jsonplaceholder.model.Post
import com.sancho.kotlin_rerofit_jsonplaceholder.model.PostsPhotoItem
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("posts")
    fun getAllPosts():Call<ArrayList<Post>>

    @GET("photos")
    fun getAllPhotos():Call<ArrayList<PostsPhotoItem>>
}