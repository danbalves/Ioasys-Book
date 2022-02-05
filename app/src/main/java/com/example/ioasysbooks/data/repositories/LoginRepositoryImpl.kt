package com.example.ioasysbooks.data.repositories

import com.example.ioasysbooks.data.datasource.LoginDatasource
import com.example.ioasysbooks.domain.model.User
import com.example.ioasysbooks.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDatasource: LoginDatasource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> =
        loginDatasource.login(email, password)
}