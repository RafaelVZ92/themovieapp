package com.example.themovieapp.data.model.action

sealed class LoginActions {
    object Success : LoginActions()
    object Error: LoginActions()
}
