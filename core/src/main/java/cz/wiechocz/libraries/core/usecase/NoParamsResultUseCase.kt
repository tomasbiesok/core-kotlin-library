package cz.wiechocz.libraries.core.usecase

import cz.wiechocz.libraries.core.result.Result

/**
 * Use case which hasn't input params ([Unit]) and returns [Result]
 */
abstract class NoParamsResultUseCase<OUT>: ResultUseCase<Unit, OUT>()