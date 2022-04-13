package com.toshihirooya.androidtesttips

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Created by t-oya on 2017/12/12.
 */
@Singleton
class SampleUseCase @Inject
constructor(private val sampleRepository: SampleRepository) {

    fun get(): Single<String> = sampleRepository.getString()

    fun put(value: String) {
        sampleRepository.putString(value)
    }
}