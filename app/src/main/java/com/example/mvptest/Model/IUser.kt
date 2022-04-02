package com.example.mvptest.Model

interface IUser {
    val email: String
    val password: String
    fun isDataValid(): Int
}