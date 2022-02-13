package com.example.ioasysbooks.data_local.datasource

import com.example.ioasysbooks.data.datasource.local.LoginLocalDataSource
import com.example.ioasysbooks.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.example.ioasysbooks.data_local.utils.SharedPreferencesHelper

class LoginLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): LoginLocalDataSource {

    override fun saveAccessToken(accessToken: String) = sharedPreferencesHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = accessToken
    )
}