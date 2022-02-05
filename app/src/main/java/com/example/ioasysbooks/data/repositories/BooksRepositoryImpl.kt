package com.example.ioasysbooks.data.repositories

import com.example.ioasysbooks.data.datasource.BooksDatasource
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val booksDatasource: BooksDatasource
): BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksDatasource.getBooks(accessToken, query)
}