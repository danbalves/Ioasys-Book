package com.example.ioasysbooks.presentation.adapter

import com.example.ioasysbooks.domain.model.Book

interface BookClickListener {

    fun onBookClickListener(book: Book)
}