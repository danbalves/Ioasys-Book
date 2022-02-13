package com.example.ioasysbooks.di

import com.example.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.example.ioasysbooks.data.datasource.remote.LoginRemoteDataSource
import com.example.ioasysbooks.data_remote.datasource.BooksRemoteDataSourceImpl
import com.example.ioasysbooks.data_remote.datasource.LoginRemoteDataSourceImpl
import com.example.ioasysbooks.data_remote.service.AuthService
import com.example.ioasysbooks.data_remote.service.BookService
import com.example.ioasysbooks.data_remote.utils.ApiConstants
import com.example.ioasysbooks.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<BookService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<BooksRemoteDataSource> {
        BooksRemoteDataSourceImpl(get())
    }

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }
}