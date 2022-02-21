package com.example.ioasysbooks.data_remote.datasource

import com.example.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.example.ioasysbooks.data_remote.mappers.toDomain
import com.example.ioasysbooks.data_remote.service.BookService
import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDataSourceImpl(
    private val bookService: BookService,
) : BooksRemoteDataSource {

    override fun getRemoteBooks(accessToken: String): Flow<List<Book>> = flow {
        val response = bookService.getBooksService(accessToken = "Bearer $accessToken", page = 1)
        if (response.isSuccessful){
            response.body()?.data?.toDomain()
        }
    }

    override fun getSearchBook(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val response = bookService.getSearchBookService(accessToken = "Bearer $accessToken", page = 2, title = query?:"")
        if (response.isSuccessful){
            response.body()?.data?.let { bookListRemote -> 
                query?.let { 
                    emit(bookListRemote.filter { book -> 
                        book.title?.trim()?.contains(it, ignoreCase = true) ?: false
                    }.toDomain())
                } ?: run{
                    emit(listOf())
                }
            }
        }
    }


}