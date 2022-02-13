package com.example.ioasysbooks.data.datasource.local

interface LoginLocalDataSource {

    fun saveAccessToken(accessToken: String)
}