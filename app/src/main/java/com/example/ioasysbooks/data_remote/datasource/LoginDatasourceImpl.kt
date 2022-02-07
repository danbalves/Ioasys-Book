package com.example.ioasysbooks.data_remote.datasource

import com.example.ioasysbooks.data.datasource.LoginDatasource
import com.example.ioasysbooks.data_remote.mappers.toDomain
import com.example.ioasysbooks.data_remote.model.LoginRequest
import com.example.ioasysbooks.data_remote.service.AuthService
import com.example.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDatasourceImpl(
    private val authService: AuthService
): LoginDatasource {

    override fun login(email: String, password: String): Flow<User> = flow {
        val response = authService.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]
        if(response.isSuccessful){
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken?: ""))
            }
        }
    }
}