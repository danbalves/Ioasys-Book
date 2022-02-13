package com.example.ioasysbooks.data.datasource.remote

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}