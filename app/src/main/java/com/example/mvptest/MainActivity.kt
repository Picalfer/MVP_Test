package com.example.mvptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvptest.Presenter.ILoginPresenter
import com.example.mvptest.Presenter.LoginPresenter
import com.example.mvptest.View.ILoginView
import com.example.mvptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ILoginView {

    internal lateinit var loginPresenter: ILoginPresenter
    lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)


        //Init
        loginPresenter = LoginPresenter(this)

        //Event
        b.btnLogin.setOnClickListener {
            loginPresenter.onLogin(b.edtEmail.text.toString(), b.edtPassword.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show()
        // Toasty.success
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show()
        // Toasty.error
    }
}