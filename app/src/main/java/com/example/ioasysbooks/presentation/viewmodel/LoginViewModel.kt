package com.example.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ioasysbooks.domain.repositories.LoginRepository
import com.example.ioasysbooks.util.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
): ViewModel(){

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String){

        viewModelScope.launch{

            _loggedUserViewState.postLoading()

            try {
                loginRepository.login(email, password).collectLatest {
                    if(it.name.isNotEmpty()) {
                        _loggedUserViewState.postSuccess(true)
                    } else {
                        _loggedUserViewState.postError(Exception("Usuário vazio!"))
                    }
                }
            } catch (err: Exception){
                _loggedUserViewState.postError(err)
            }
        }
    }

    fun resetViewState(){
        _loggedUserViewState.postNeutral()
    }
}
