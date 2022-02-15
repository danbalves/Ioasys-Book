package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.repositories.BooksRepository
import com.example.ioasysbooks.util.ViewState
import com.example.ioasysbooks.util.postError
import com.example.ioasysbooks.util.postLoading
import com.example.ioasysbooks.util.postSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookListViewModel(
    private val booksRepository: BooksRepository
): ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = ""){
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(input).collect {
                    if(it.isNotEmpty()) {
                        saveBooks(bookList = it)
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

    private fun saveBooks(bookList: List<Book>){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    booksRepository.saveBooks(bookList = bookList)

                }
                print("success")
            } catch (err: Exception){
                print(err)
            }
        }
    }
}