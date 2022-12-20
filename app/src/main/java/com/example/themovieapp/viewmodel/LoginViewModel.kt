package com.example.themovieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themovieapp.data.model.action.LoginActions
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    private val action = MutableLiveData<LoginActions>()

    fun getAction() = action

    fun loginMovieApp(
        user: String,
        password: String
    ) {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(
            user, password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                action.value = LoginActions.Success
            } else {
                action.value = LoginActions.Error
            }
        }
    }

    fun logout() {
        FirebaseAuth.getInstance().signOut()
    }
}