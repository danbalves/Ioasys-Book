package com.example.ioasysbooks.data_local.database

import androidx.room.Dao

@Dao
interface BookDao {

    //!! COMENTADO TEMPORARIAMENTE!!

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addBooks(bookList: List<BookDataLocal>)

//    @Query("SELECT * FROM Books")
//    fun getBooks(): List<BookDataLocal>
}