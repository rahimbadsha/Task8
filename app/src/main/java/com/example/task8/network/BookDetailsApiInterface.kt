package com.example.task8.network

import com.example.task8.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface BookDetailsApiInterface {

    @GET("rahimbadsha/Task6/master/app/book_list.json")

    fun getDetails(): Call<MutableList<Book>>
}