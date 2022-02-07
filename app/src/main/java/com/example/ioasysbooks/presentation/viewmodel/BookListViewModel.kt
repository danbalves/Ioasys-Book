package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import com.example.ioasysbooks.util.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookListViewModel(
    private val booksRepository: BooksRepository
): ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "", accessToken: String){
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(accessToken, input).collect {
                    if(it.isNotEmpty()) {
                        _bookListViewState.postSuccess(it)
                    } else {
                        _bookListViewState.postError(Exception("Algo deu errado!!"))
                    }
                }
            } catch(err: Exception){
                _bookListViewState.postError(err)
            }
        }
    }
}