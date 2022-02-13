package com.example.ioasysbooks.data_local.utils

import android.content.Context
import com.example.ioasysbooks.data_local.utils.LocalConstants.SHARED_PREFERENCES_NAME

class SharedPreferencesHelper(
    context: Context
) {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_NAME,
        Context.MODE_PRIVATE
    )

    fun saveString(key: String, value: String) = sharedPreferences.edit().run {
        putString(key, value)
        apply()
    }

    fun getString(Key: String): String = sharedPreferences.getString(Key, "")?:""
}