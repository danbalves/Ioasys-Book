package com.example.ioasysbooks.domain.repositories

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    //foi alterado
//    fun getBooksRepository(query: String?): Flow<List<Book>>

    fun getBooksRepository(): Flow<List<Book>>
    fun saveBooks(bookList: List<Book>)

    // this is new
    fun getSearchBookRepository(query: String): Flow<List<Book>>

}