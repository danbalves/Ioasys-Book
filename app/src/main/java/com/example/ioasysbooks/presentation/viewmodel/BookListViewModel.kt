package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.usecase.GetBookListUseCase
import com.example.ioasysbooks.domain.usecase.GetSearchBookUseCase
import com.example.ioasysbooks.domain.usecase.SaveBookListUseCase
import com.example.ioasysbooks.util.ViewState
import com.example.ioasysbooks.util.postError
import com.example.ioasysbooks.util.postLoading
import com.example.ioasysbooks.util.postSuccess

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase,
    private val getSearchBookUseCase: GetSearchBookUseCase
): ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun putBookListOnView(){
        _bookListViewState.postLoading()
        getBookListUseCase(
            Unit,
            onSuccess = {
                saveBooks(bookList = it)
            },
            onError = {
                _bookListViewState.postError(it)
            }
        )
    }

    fun searchBooks(input: String = ""){
        getSearchBookUseCase(
            GetSearchBookUseCase.Params(
                input = input
            ),
            onSuccess = {
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