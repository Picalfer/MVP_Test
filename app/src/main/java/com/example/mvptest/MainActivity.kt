package com.example.mvptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvptest.presenter.ILoginPresenter
import com.example.mvptest.presenter.LoginPresenter
import com.example.mvptest.view.ILoginView
import com.example.mvptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ILoginView {

    private lateinit var loginPresenter: ILoginPresenter
    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        //Init
        loginPresenter = LoginPresenter(this)

        //Event
        b.btnLogin.setOnClickListener {
            loginPresenter.onLogin(b.edtEmail.text.toString(), b.edtPassword.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}