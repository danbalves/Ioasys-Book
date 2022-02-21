package com.example.ioasysbooks.data_local.datasource

import com.example.ioasysbooks.data.datasource.local.BooksLocalDataSource
import com.example.ioasysbooks.data_local.database.BookDao
import com.example.ioasysbooks.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.example.ioasysbooks.data_local.utils.SharedPreferencesHelper
import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// foi alterado
class BooksLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val bookDao: BookDao
): BooksLocalDataSource {

    override fun getAccessToken(): Flow<String> = flow{
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }

    override fun saveBooks(bookList: List<Book>) {
        TODO("Not yet implemented")
    }

    //!! COMENTADO TEMPORARIAMENTE!!


//    override fun saveBooks(bookList: List<Book>) = bookDao.addBooks(
//        bookList = bookList.map { it.toDao() }
//    )

//    override fun getLocalBooks(): Flow<List<Book>> = flow {
//        val bookList = bookDao.getBooks().map { it.toDomain() }
//        emit(bookList)
//    }

}