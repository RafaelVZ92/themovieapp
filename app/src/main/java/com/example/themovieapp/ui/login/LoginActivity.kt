package com.example.themovieapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.appthemoviedb.MainActivity
import com.example.themovieapp.data.model.action.LoginActions
import com.example.themovieapp.databinding.ActivityLoginBinding
import com.example.themovieapp.viewmodel.LoginViewModel
import com.google.firebase.FirebaseApp
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LoginActivity : AppCompatActivity(),
    HasAndroidInjector {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(binding.root)
        bindViewModel()
        emailFocusListener()
        passwordFocusListener()
        configureLoginButton()
    }

    private fun bindViewModel() {
        viewModel.getAction().observe(this, Observer(::handleActions))
    }

    private fun handleActions(actions: LoginActions) {
        when(actions){
            LoginActions.Success -> startActivity(
                Intent(this, MainActivity::class.java)
            )
            LoginActions.Error -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "fields cannon be null",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun configureLoginButton() {
        binding.buttonLogin?.setOnClickListener {
            binding.apply {
                if (
                    textInputEditTextUser?.text?.isNotEmpty() == true &&
                            textInputEditTextPassword?.text?.isNotEmpty() == true
                ){
                    viewModel.loginMovieApp(
                        textInputEditTextUser.text.toString(),
                        textInputEditTextPassword.text.toString()
                    )
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuario no registrado",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun emailFocusListener() {
        binding.textInputEditTextUser?.apply {
            setOnFocusChangeListener { _, focused ->
                if (!focused) {
                    binding.textInputLayoutUser?.apply {
                        error = validEmail()
                    }
                }
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.textInputEditTextUser?.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.textInputEditTextPassword?.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.textInputLayoutPassword?.error = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.textInputEditTextPassword?.text.toString()
        if (passwordText.length < 8) {
            return "Minimum 8 Character Password"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper-case Character"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower-case Character"
        }
        if (!passwordText.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }
        return null
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

}