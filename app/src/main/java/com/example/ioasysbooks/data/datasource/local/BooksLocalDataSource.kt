package com.example.ioasysbooks.data.datasource.local

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
    fun saveBooks(bookList: List<Book>)
}