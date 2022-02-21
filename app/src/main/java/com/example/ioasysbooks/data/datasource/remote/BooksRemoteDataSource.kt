package com.example.ioasysbooks.data.datasource.remote

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

//foi alterado
interface BooksRemoteDataSource {

    fun getRemoteBooks(accessToken: String): Flow<List<Book>>
    fun getSearchBook(accessToken: String, query: String?): Flow<List<Book>>
}