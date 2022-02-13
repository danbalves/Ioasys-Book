package com.example.ioasysbooks.data_remote.datasource

import com.example.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.example.ioasysbooks.data_remote.mappers.toDomain
import com.example.ioasysbooks.data_remote.service.BookService
import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDataSourceImpl(
    private val bookService: BookService
): BooksRemoteDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val response = bookService.getBooks(accessToken = "Bearer $accessToken", page = 1)
        if(response.isSuccessful){
            response.body()?.data?.let { bookList ->
                query?.let {
                    emit(bookList.filter { book ->
                        book.name?.trim()?.contains(it, ignoreCase = true) ?: false
                    }.toDomain())
                } ?: run {
                    emit(bookList.toDomain())
                }
            }
        }
    }
}