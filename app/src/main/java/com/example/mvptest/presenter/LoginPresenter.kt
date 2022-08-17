package com.example.mvptest.presenter

import com.example.mvptest.view.ILoginView
import com.example.mvptest.model.User

class LoginPresenter(private var iLoginView: ILoginView) : ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        when (user.isDataValid()) {
            0 -> iLoginView.onLoginError("Email must not be null")
            1 -> iLoginView.onLoginError("Wrong email address")
            2 -> iLoginView.onLoginError("Password must be greater than 6")
            else -> iLoginView.onLoginSuccess("Login Success")
        }
    }
}