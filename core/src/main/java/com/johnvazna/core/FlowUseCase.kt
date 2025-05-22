package com.johnvazna.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<P, R> {

    protected abstract suspend fun build(params: P): R

    operator fun invoke(params: P): Flow<Result<R>> = flow {
        emit(Result.Loading)
        try {
            val data = build(params)
            emit(Result.Success(data))
        } catch (t: Throwable) {
            emit(Result.Error(t))
        }
    }.flowOn(Dispatchers.IO)
}
