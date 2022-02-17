package com.example.ioasysbooks.domain.usecase

import com.example.ioasysbooks.domain.exception.InvalidEmailException
import com.example.ioasysbooks.domain.exception.InvalidPasswordException
import com.example.ioasysbooks.domain.model.User
import com.example.ioasysbooks.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    operator fun invoke(params: Params): Flow<User> = when{
        params.email.isEmpty() -> throw InvalidEmailException()
        params.password.isEmpty() -> throw InvalidPasswordException()
        else -> {
            loginRepository.login(
                email = params.email,
                password = params.password
            )
        }
    }

    data class Params(
        val email: String,
        val password: String
    )
}