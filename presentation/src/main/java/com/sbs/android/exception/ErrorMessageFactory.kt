package com.sbs.android.exception

import java.net.UnknownHostException

object ErrorMessageFactory {

    fun create(throwable: Throwable): String {
        if (throwable is UnknownHostException) return "No Connection to server"

        if (throwable is AuthException) {
            if (throwable is EmptyPasswordException) return "Please enter password"
        }

        return throwable.message.orEmpty()
    }
}