package com.example.ioasysbooks.di

import com.example.ioasysbooks.presentation.viewmodel.BookListViewModel
import com.example.ioasysbooks.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
    viewModel { LoginViewModel( get() ) }
    viewModel { BookListViewModel( get(), get(), get() ) }
}