package com.example.task8.customAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task8.R
import com.example.task8.model.Book
import com.example.task8.core.ItemClickListener

class BookListAdapter(
    private val bookList: MutableList<Book>,
    private val clickedListener: ItemClickListener
): RecyclerView.Adapter<BookListViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return BookListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {

        val book = bookList[position]

        Glide.with(context)
            .load(book.imageUrl)
            .centerCrop()
            .error(R.drawable.error)
            .into(holder.ivBookImage)

        holder.tvName.text = book.name
        holder.tvDescription.text = book.description
        holder.tvAuthor.text = book.author

        // Show price if there is any discount or not
        val discountPrice = book.discount
        if (discountPrice == 0)
        {
            holder.tvPrice.visibility = View.GONE
            holder.tvDiscountPrice.text = holder.itemView.context.getString(
                R.string.price_format, book.price)
        }
        else
        {
            val currentPrice = book.price

            val discountValue = currentPrice - discountPrice

            holder.tvPrice.text = holder.itemView.context.getString(
                R.string.price_format, book.price)
            holder.tvDiscountPrice.text = holder.itemView.context.getString(
                R.string.price_format, discountValue)
        }

        // Show ratings
        val userRatings = book.rating
        holder.rbRatings.rating = userRatings

        // onItem click listener
        holder.itemView.setOnClickListener {
            clickedListener.onItemClicked(position)
        }
    }
}