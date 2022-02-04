package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.model.exception.EmptyBookListException
import com.example.ioasysbooks.util.ViewState
import com.example.ioasysbooks.util.postError
import com.example.ioasysbooks.util.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel: ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDataList: List<Book> by lazy { Book.getMockList() }

    private fun getBooks(input: String): List<Book>{

        if (input.trim().isEmpty()) {
            return bookDataList
        } else {
            return bookDataList.filter { book ->
                book.name.trim().contains(input, ignoreCase = true)
            }
        }
    }

    fun search(input: String = ""){

        viewModelScope.launch {
            getBooks(input).let { books ->
                when{
                    books.isNotEmpty() -> {
                    _bookListViewState.postSuccess(books)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookListException())
                    }
                }
            }
        }
    }
}