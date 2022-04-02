package com.example.mvptest.Presenter

import com.example.mvptest.Model.User
import com.example.mvptest.View.ILoginView

class LoginPresenter(internal var iLoginView: ILoginView): ILoginPresenter{
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode = user.isDataValid()
        if (loginCode == 0)
            iLoginView.onLoginError("Email must not be null")
        else if (loginCode == 1)
            iLoginView.onLoginError("Wrong email address")
        else if (loginCode == 2)
            iLoginView.onLoginError("Password must be greater than 6")
        else
            iLoginView.onLoginSuccess("Login Success")
    }
}