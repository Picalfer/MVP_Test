package com.example.mvptest.Model

import android.text.TextUtils
import android.util.Patterns

class User(override val email: String, override val password: String): IUser {
    override fun isDataValid(): Int {
        if (TextUtils.isEmpty(email)) // походу empty.isEmpty() это тоже самое
            return 0 // 0 - error code is email empty
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1 // 1 - error code is wrong patterns
        else if (password.length <= 6)
            return 2 // 2 - error code is password length must be greater than 6
        else
            return -1 // -1 - success code
    }

}