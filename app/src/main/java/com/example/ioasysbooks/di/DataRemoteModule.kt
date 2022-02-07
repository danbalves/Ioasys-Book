package com.example.ioasysbooks.di

import com.example.ioasysbooks.data.datasource.BooksDatasource
import com.example.ioasysbooks.data.datasource.LoginDatasource
import com.example.ioasysbooks.data_remote.datasource.BooksDatasourceImpl
import com.example.ioasysbooks.data_remote.datasource.LoginDatasourceImpl
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

    single<BooksDatasource> {
        BooksDatasourceImpl(get())
    }

    single<LoginDatasource> {
        LoginDatasourceImpl(get())
    }
}