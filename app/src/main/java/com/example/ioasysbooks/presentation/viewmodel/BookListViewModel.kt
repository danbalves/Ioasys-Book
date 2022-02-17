package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.usecase.GetBookListUseCase
import com.example.ioasysbooks.domain.usecase.SaveBookListUseCase
import com.example.ioasysbooks.util.ViewState
import com.example.ioasysbooks.util.postError
import com.example.ioasysbooks.util.postLoading
import com.example.ioasysbooks.util.postSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase
): ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = ""){
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                withContext(Dispatchers.IO){
                    getBookListUseCase(
                         params = GetBookListUseCase.Params(
                             input = input
                         )
                    ).collect {
                        saveBooks(bookList = it)
                        _bookListViewState.postSuccess(it)
                    }
                }
            } catch(err: Exception){
                withContext(Dispatchers.Main){
                    _bookListViewState.postError(err)
                }
            }
        }
    }

    private fun saveBooks(bookList: List<Book>){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    saveBookListUseCase(
                        params = SaveBookListUseCase.Params(
                            bookList = bookList
                        )
                    )
                }
            } catch (err: Exception){
                return@launch
            }
        }
    }
}