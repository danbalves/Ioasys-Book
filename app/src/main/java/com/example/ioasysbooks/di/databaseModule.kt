package com.example.ioasysbooks.di

import androidx.room.Room
import com.example.ioasysbooks.data_local.database.BookDatabase
import com.example.ioasysbooks.data_local.utils.LocalConstants.BOOK_DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            BookDatabase::class.java,
            BOOK_DATABASE_NAME
        ).build()
    }

    single { get<BookDatabase>().bookDao() }
}