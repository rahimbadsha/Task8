package com.example.task8

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task8.core.BaseActivity
import com.example.task8.customAdapter.BookListAdapter
import com.example.task8.model.Book
import com.example.task8.model.BookListCallback
import com.example.task8.model.BookListModel
import com.example.task8.model.BookListModelImpl
import com.example.task8.core.ItemClickListener
import com.example.task8.view.BookListDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {
    override fun setLayoutId(): Int = R.layout.activity_main

    override fun setTooldBar(): Toolbar {
        toolbar.title = getString(R.string.app_name)
        return toolbar
    }
    override val isHomeUpButtonEnable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showBookList()
    }

    private fun showBookList() {

        progress.visibility = View.VISIBLE

        val bookModel : BookListModel = BookListModelImpl()

        bookModel.getBookLists(object : BookListCallback{
            override fun onSuccess(bookList: MutableList<Book>) {
                progress.visibility = View.GONE
                initAdapter(bookList)
            }

            override fun onFailure(throwable: Throwable) {
                progress.visibility = View.GONE
                showToast(throwable.localizedMessage)
            }

        })
    }

    @SuppressLint("WrongConstant")
    private fun initAdapter(bookList: MutableList<Book>) {

        val adapter = BookListAdapter(bookList, object : ItemClickListener {
            override fun onItemClicked(position: Int) {
                intent = Intent(this@MainActivity, BookListDetailsActivity::class.java)
                startActivity(intent)
                //showToast("Hello This clicked")
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView.adapter = adapter
    }
}
