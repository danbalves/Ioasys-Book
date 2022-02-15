package com.example.ioasysbooks.data.repositories

import com.example.ioasysbooks.data.datasource.local.BooksLocalDataSource
import com.example.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {

    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect { token ->

            if (token.isNotEmpty()) {
                booksLocalDataSource.getBooks(query = query).collect { bookList ->
                    if (bookList.isEmpty()) {
                        booksRemoteDataSource.getBooks(token, query).collect { bookResponse ->
                            saveBooks(bookResponse)
                            emit(bookResponse)
                        }
                    } else {
                        emit(bookList)
                    }
                }
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = booksLocalDataSource.saveBooks(
        bookList = bookList
    )

}