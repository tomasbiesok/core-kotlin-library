package cz.wiechocz.libraries.core.extensions

import cz.wiechocz.libraries.core.result.Result

/**
 * Call body in try-catch block. If [body] doesn't throws exception, function returns [Result] from [body] function.
 * If something fails and [body] throws exception, function returns [Result.Error] with exception
 */
suspend fun <TYPE> safeCall(body: suspend () -> Result<TYPE>): Result<TYPE> {
    return try {
        body.invoke()
    } catch (ex: Exception) {
        Result.Error(ex)
    }
}

/**
 * Call body in try-catch block. If [body] doesn't throws exception, function returns [Result.Success].
 * If something fails and [body] throws exception, function returns [Result.Error] with exception
 */
suspend fun <TYPE> safeCallUnit(body: suspend () -> Unit): Result<TYPE> {
    return try {
        body.invoke()
        Result.Success()
    } catch (ex: Exception) {
        Result.Error(ex)
    }
}