package com.example.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ioasysbooks.presentation.adapter.BookClickListener
import com.example.ioasysbooks.presentation.adapter.BookListAdapter
import com.example.ioasysbooks.databinding.FragmentBookListBinding
import com.example.ioasysbooks.domain.model.Book
import com.example.ioasysbooks.domain.model.exception.EmptyBookListException
import com.example.ioasysbooks.presentation.viewmodel.BookListViewModel
import com.example.ioasysbooks.util.ViewState

class BookListFragment : Fragment(), BookClickListener {

    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val viewModel: BookListViewModel by viewModels()

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
        binding.editSearch.textChangeListener = {input ->
            viewModel.search(input)
        }
    }


    private fun setBookListData(){
        bookListAdapter = BookListAdapter(this)
        binding.recycleView.adapter = bookListAdapter
        viewModel.search("")
    }

    private fun addObserver() {

        viewModel.bookListViewState.observe(viewLifecycleOwner){ state ->

            when(state){
                is ViewState.Success -> {
                    binding.textViewEmptyList.visibility = View.GONE
                    bookListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when(state.throwable){
                        is EmptyBookListException -> {
                            bookListAdapter.submitList(listOf())
                            binding.textViewEmptyList.visibility = View.VISIBLE
                        }
                        else -> Unit
                    }
                }
                else -> Unit
            }
        }
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}