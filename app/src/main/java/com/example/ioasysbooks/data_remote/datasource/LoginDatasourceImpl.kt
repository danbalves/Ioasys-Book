package com.example.ioasysbooks.data_remote.datasource

import com.example.ioasysbooks.data.datasource.LoginDatasource
import com.example.ioasysbooks.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDatasourceImpl: LoginDatasource {

    override fun login(email: String, password: String): Flow<User> = flow {
        delay(3_000)

        emit(User(
            name = "Daniel",
            birthdate = "24/10/2001",
            gender = "M",
            accessToken = "A1b2345"
        ))
    }
}