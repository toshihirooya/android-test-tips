package com.toshihirooya.androidtesttips

import android.content.Context
import android.preference.PreferenceManager
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Created by toshihirooya on 2017/12/12.
 */
@Singleton
open class SamplePreferences @Inject
constructor(context: Context) {
    private val preference = PreferenceManager.getDefaultSharedPreferences(context)

    open fun getPrefString(key: String): Single<String> {
        return Single.just(preference.getString(key, ""))
    }

    open fun putPrefString(key: String, value: String) {
        preference.edit().putString(key, value).apply()
    }
}