package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasysbooks.domain.model.exception.LoginException
import com.example.ioasysbooks.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel(){

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun Login(email: String, password: String){

        viewModelScope.launch{

            _loggedUserViewState.postLoading()
            delay(2_000)

            if(email.isNotEmpty() && password.isNotEmpty()){
                _loggedUserViewState.postSuccess(true)
            } else{
                _loggedUserViewState.postError(LoginException())
            }
        }
    }

    fun resetViewState(){
        _loggedUserViewState.postNeutral()
    }
}
