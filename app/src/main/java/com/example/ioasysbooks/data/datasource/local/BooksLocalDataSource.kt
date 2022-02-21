package com.example.ioasysbooks.data.datasource.local

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

//precisa de altações e foi alterado
interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>

    //!! COMENTADO TEMOPORARIAMENTE!!
    fun saveBooks(bookList: List<Book>)
//    fun getLocalBooks(query: String?): Flow<List<Book>>

//    fun getLocalBooks(): Flow<List<Book>>
}