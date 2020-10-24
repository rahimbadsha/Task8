package com.example.task8.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.task8.R
import com.example.task8.core.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class BookListDetailsActivity : BaseActivity() {
    override fun setLayoutId(): Int = R.layout.activity_book_list_details

    override fun setTooldBar(): Toolbar {
        toolbar.title = "Details Activity"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showBookDetails()

    }

    private fun showBookDetails() {
        
    }
}
