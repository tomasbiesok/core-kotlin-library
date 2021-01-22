package cz.wiechocz.libraries.core.usecase

/**
 * Use case which has no input params (input is [Unit])
 */
abstract class NoParamsUseCase<OUT>: UseCase<Unit, OUT>()