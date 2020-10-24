package com.example.task8.model

import com.example.task8.network.BookListApiInterface
import com.example.task8.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class BookListModelImpl: BookListModel {

    private val apiInterface =
        RetrofitClient.getClient().create(BookListApiInterface::class.java)
    private val call = apiInterface.getList()

    override fun getBookLists(bookListCallback: BookListCallback) {

        call.enqueue(object : Callback<MutableList<Book>>{
            override fun onFailure(call: Call<MutableList<Book>>, t: Throwable) {
                bookListCallback.onFailure(t)
            }

            override fun onResponse(call: Call<MutableList<Book>>, response: Response<MutableList<Book>>) {
                response.body()?.let {
                    bookListCallback.onSuccess(it)
                }
            }


        })

    }
}