package com.example.mvptest.view

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}