package com.example.ioasysbooks.di

import com.example.ioasysbooks.data.datasource.BooksDatasource
import com.example.ioasysbooks.data.datasource.LoginDatasource
import com.example.ioasysbooks.data_remote.datasource.BooksDatasourceImpl
import com.example.ioasysbooks.data_remote.datasource.LoginDatasourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single <BooksDatasource> {
        BooksDatasourceImpl()
    }

    single <LoginDatasource>{
        LoginDatasourceImpl()
    }
}