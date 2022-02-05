package com.example.ioasysbooks.data.datasource

import com.example.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDatasource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}