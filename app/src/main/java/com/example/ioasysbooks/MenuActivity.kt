package com.example.ioasysbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.ioasysbooks.adapter.BookListAdapter
import com.example.ioasysbooks.models.Book


class MenuActivity : AppCompatActivity() {

    private lateinit var bookListAdapter: BookListAdapter

    private val rvBooks: RecyclerView by lazy {

        findViewById(R.id.recycle_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val logOutButton = findViewById<ImageButton>(R.id.logOutButton)

        setBookListData()

        logOutButton.setOnClickListener {
            startMainActivity()
        }
    }

    private fun setBookListData(){

        bookListAdapter = BookListAdapter()
        rvBooks.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getMockList())
    }

    private fun startMainActivity() {

        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)

    }
}