package com.example.ioasysbooks.domain.repositories

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>

}