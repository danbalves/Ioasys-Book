package com.example.ioasysbooks.data.datasource.local

import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
}