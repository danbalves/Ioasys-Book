package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.usecase.GetBookListUseCase
import com.example.ioasysbooks.domain.usecase.SaveBookListUseCase
import com.example.ioasysbooks.util.ViewState
import com.example.ioasysbooks.util.postError
import com.example.ioasysbooks.util.postLoading
import com.example.ioasysbooks.util.postSuccess

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase
): ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = ""){
        _bookListViewState.postLoading()
        getBookListUseCase(
            params = GetBookListUseCase.Params(
                input = input
            ),
            onSuccess = {
                saveBooks(bookList = it)
                _bookListViewState.postSuccess(it)
            },
            onError = {
                _bookListViewState.postError(it)
            }
        )
    }

    private fun saveBooks(bookList: List<Book>){
        saveBookListUseCase(
            params = SaveBookListUseCase.Params(
                bookList = bookList
            )
        )
    }
}