package com.toshihirooya.androidtesttips

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * リポジトリクラス
 * Created by toshihirooya on 2017/12/12.
 */
@Singleton
open class SampleRepository @Inject
constructor(private var preference: SamplePreferences) {

    // キャッシュ
    val cache: MutableMap<String, String> = HashMap()
    // プリファレンスキー
    val PREF_KEY = "pref_key"

    fun putString(value: String) {
        preference.putPrefString(PREF_KEY, value)
        cache[PREF_KEY] = value
    }

    fun getString(): Single<String> {
        if (cache.containsKey(PREF_KEY)) {
            return Single.just(cache[PREF_KEY])
        }
        return preference.getPrefString(PREF_KEY)
    }
}