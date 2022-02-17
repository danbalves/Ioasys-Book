package com.example.ioasysbooks.domain.usecase

import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(
    private val booksRepository: BooksRepository
) {

    operator fun invoke(params: Params): Flow<List<Book>> = booksRepository.getBooks(
        query = params.input
    )

    data class Params(
        val input: String,
    )
}