package com.sbs.android.utils

/*sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(message: String, data: T? = null) : Result<T>(data, message)
}*/

public sealed class Results<out T : Any>{
    public object Empty : Results<Nothing>()
    public object Loading : Results<Nothing>()
    public data class Error(val throwable: Throwable) : Results<Nothing>()
    public data class Loaded<out T : Any>(val content: T) : Results<T>()
}
