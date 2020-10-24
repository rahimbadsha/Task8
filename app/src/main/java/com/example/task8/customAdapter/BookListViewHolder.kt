package com.example.task8.customAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_book.view.*

class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val ivBookImage = itemView.iv_book
    val tvName = itemView.tv_book_title
    val tvDescription = itemView.tv_description
    val tvAuthor = itemView.tv_author_value
    val tvPrice = itemView.tv_price_value
    val tvDiscountPrice = itemView.tv_price_value2
    val rbRatings = itemView.ratingBar
}