package cz.wiechocz.libraries.core.usecase

import cz.wiechocz.libraries.core.result.Result

/**
 * Use case which must returns [Result]
 */
abstract class ResultUseCase<IN, OUT> : UseCase<IN, Result<OUT>>()