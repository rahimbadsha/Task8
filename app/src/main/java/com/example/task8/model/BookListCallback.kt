package com.example.task8.model

interface BookListCallback {

    fun onSuccess(bookList: MutableList<Book>)
    fun onFailure(throwable: Throwable)
}