package com.example.mvptest.model

interface IUser {
    val email: String
    val password: String
    fun isDataValid(): Int
}