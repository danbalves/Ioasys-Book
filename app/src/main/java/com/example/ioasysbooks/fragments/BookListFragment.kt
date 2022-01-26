package com.example.ioasysbooks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.ioasysbooks.R
import com.example.ioasysbooks.adapter.BookListAdapter
import com.example.ioasysbooks.databinding.FragmentBookListBinding
import com.example.ioasysbooks.databinding.FragmentLoginBinding
import com.example.ioasysbooks.models.Book

class BookListFragment : Fragment() {

    private val args: BookListFragmentArgs by navArgs()
    private lateinit var bookListAdapter: BookListAdapter

    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBookListData()
    }


    private fun setBookListData(){

        bookListAdapter = BookListAdapter()
        binding.recycleView.adapter = bookListAdapter

        bookListAdapter.submitList(
            Book.getMockListCount(
                args.itemCount
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}