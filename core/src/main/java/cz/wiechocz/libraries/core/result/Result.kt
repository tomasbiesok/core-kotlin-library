package cz.wiechocz.libraries.core.result

sealed class Result<TYPE>(val data: TYPE?) {

    class Success<TYPE>(data: TYPE? = null): Result<TYPE>(data)
    class Error<TYPE>(val exception: Throwable, message: String = "", data: TYPE? = null): Result<TYPE>(data)

    fun isSuccess() = this is Success

    fun isError() = this is Error

    fun getNotNullData() = data ?: Exception("Data is null")

    fun getNotNullException() = (this as? Error)?.exception ?: Exception("Result is not Error")
}