package com.example.ioasysbooks.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ioasysbooks.R
import com.example.ioasysbooks.models.Book



class BookListAdapter: ListAdapter<Book, BookListAdapter.BookListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Book>(){

            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem == newItem

        }
    }

    class BookListViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val bookTitle: AppCompatTextView = view.findViewById(R.id.tvTitleBook)
        private val bookAuthor: AppCompatTextView = view.findViewById(R.id.txtAuthorName)
        private val bookPageCount: AppCompatTextView = view.findViewById(R.id.tvPagesCount)
        private val bookPublisher: AppCompatTextView = view.findViewById(R.id.tvPublisher)
        private val bookPublished: AppCompatTextView = view.findViewById(R.id.tvPublished)


        fun bind(book: Book){

            bookTitle.text = book.title
            bookAuthor.text = book.author
            bookPageCount.text = book.pageCount
            bookPublisher.text = book.publisher
            bookPublished.text = book.published

        }

        companion object {

            fun create(parent: ViewGroup):BookListViewHolder{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book_rc, parent, false)

                return BookListViewHolder(view)
            }
        }
    }

}