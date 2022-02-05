package com.example.ioasysbooks.domain.repositories

import com.example.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String): Flow<User>
}