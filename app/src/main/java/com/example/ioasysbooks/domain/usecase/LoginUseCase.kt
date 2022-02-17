package com.example.ioasysbooks.domain.usecase

import com.example.ioasysbooks.domain.exception.InvalidEmailException
import com.example.ioasysbooks.domain.exception.InvalidPasswordException
import com.example.ioasysbooks.domain.model.User
import com.example.ioasysbooks.domain.repositories.LoginRepository
import com.example.ioasysbooks.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository,
    scope: CoroutineScope
) : UseCase<LoginUseCase.Params, User>(scope = scope) {

    override fun run(params: Params?): Flow<User> = when{
            params?.email?.isEmpty() == true -> throw InvalidEmailException()
            params?.password?.isEmpty() == true -> throw InvalidPasswordException()
            else -> {
                loginRepository.login(
                    email = params?.email ?: "",
                    password = params?.password ?: ""
                )
            }
        }

    data class Params(
        val email: String,
        val password: String
    )
}