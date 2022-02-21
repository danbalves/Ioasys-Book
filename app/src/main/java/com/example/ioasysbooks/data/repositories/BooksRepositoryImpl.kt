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

    //!! COMENTADO TEMPORARIAMENTE!!

    override fun getBooksRepository(): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect { token ->
            if (token.isNotEmpty()){
//                booksLocalDataSource.getLocalBooks().collect { bookListLocal ->
//                    if (bookListLocal.isEmpty()) {
//                        booksRemoteDataSource.getRemoteBooks(token).collect { bookListRemote ->
//                            saveBooks(bookListRemote)
//                            emit(bookListRemote)
//                        }
//                    } else {
//                        emit(bookListLocal)
//                    }
//                }
            }
        }
    }


    override fun getSearchBookRepository(query: String): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect { token->
            booksRemoteDataSource.getSearchBook(token, query)
            if (token.isNotEmpty()){
                booksRemoteDataSource.getSearchBook(token, query).collect { searchBookList ->
                    if (query.isNotEmpty()){
                        if (searchBookList.isEmpty()){
                            error(Throwable("Livro não encontrado"))
                        } else {
                            emit(searchBookList)
                        }
                    }
                }
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = booksLocalDataSource.saveBooks(
        bookList = bookList
    )

}