package com.example.ioasysbooks.domain.usecase

import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import com.example.ioasysbooks.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

// necessário! a class não implementa pesquisas dos livros, só passa os dados para que possamos pegar eles.
// não fazer alterações de forma alguma
//class GetBookListUseCase(
//    private val booksRepository: BooksRepository,
//    scope: CoroutineScope
//) : UseCase<GetBookListUseCase.Params, List<Book>>(scope = scope) {
//
//    override fun run(params: Params?): Flow<List<Book>> = booksRepository.getBooksRepository(
//        query = params?.input
//    )
//
//    data class Params(
//        val input: String,
//    )
//}

class GetBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<Unit?, List<Book>>(scope = scope) {

//    override fun run(params: Params?): Flow<List<Book>> = booksRepository.getBooksRepository(
//        query = params?.input
//    )
    override fun run(params: Unit?): Flow<List<Book>> = booksRepository.getBooksRepository()

}