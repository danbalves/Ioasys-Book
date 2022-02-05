package com.example.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.ioasysbooks.presentation.adapter.BookClickListener
import com.example.ioasysbooks.presentation.adapter.BookListAdapter
import com.example.ioasysbooks.databinding.FragmentBookListBinding
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.exception.EmptyBookListException
import com.example.ioasysbooks.presentation.viewmodel.BookListViewModel
import com.example.ioasysbooks.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment(), BookClickListener {

    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val booksViewModel: BookListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBookListData()
        configureListeners()
        addObserver()
    }

    private fun configureListeners(){
        binding.editSearch.textChangedListener = {input ->
            booksViewModel.search(input)
        }
    }


    private fun setBookListData(){
        bookListAdapter = BookListAdapter(this)
        binding.recycleView.adapter = bookListAdapter
        booksViewModel.search()
    }

    private fun addObserver() {

        booksViewModel.bookListViewState.observe(viewLifecycleOwner){ state ->

            when(state){
                is ViewState.Success -> {
                    showEmptyListError(false)
                    bookListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when(state.throwable){
                        is EmptyBookListException -> {
                            bookListAdapter.submitList(listOf())
                            showEmptyListError(true)
                        }
                        else -> Unit
                    }
                }
                else -> Unit
            }
        }
    }

    private fun showEmptyListError(hasError: Boolean){
        binding.textViewEmptyList.visibility = if(hasError) View.VISIBLE else View.GONE
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}