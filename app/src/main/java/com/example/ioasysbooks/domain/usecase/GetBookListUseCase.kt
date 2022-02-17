package com.example.ioasysbooks.domain.usecase

import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import com.example.ioasysbooks.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<GetBookListUseCase.Params, List<Book>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Book>> = booksRepository.getBooks(
        query = params?.input
    )

    data class Params(
        val input: String,
    )
}