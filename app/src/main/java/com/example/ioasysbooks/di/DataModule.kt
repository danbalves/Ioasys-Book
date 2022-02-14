package com.example.ioasysbooks.di

import com.example.ioasysbooks.data.repositories.BooksRepositoryImpl
import com.example.ioasysbooks.data.repositories.LoginRepositoryImpl
import com.example.ioasysbooks.domain.repositories.BooksRepository
import com.example.ioasysbooks.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single <BooksRepository> {
        BooksRepositoryImpl( get(), get() )
    }

    single <LoginRepository> {
        LoginRepositoryImpl( get(), get() )
    }

}