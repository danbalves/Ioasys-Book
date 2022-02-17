package com.example.ioasysbooks.domain.usecase

import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository

class SaveBookListUseCase(
    private val booksRepository: BooksRepository
) {

    operator fun invoke(params: Params) = booksRepository.saveBooks(
        bookList = params.bookList
    )

    data class Params(
        val bookList: List<Book>
    )
}