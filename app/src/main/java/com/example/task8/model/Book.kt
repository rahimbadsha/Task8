package com.example.task8.model

import java.io.Serializable

data class Book (
    val id: Int,
    val imageUrl: String,
    val name: String,
    val description: String,
    val author: String,
    val price: Int,
    val discount: Int,
    val rating: Float
) :Serializable