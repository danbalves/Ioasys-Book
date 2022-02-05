package com.example.ioasysbooks.data.datasource

import com.example.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {

    fun login(email: String, password: String): Flow<User>
}