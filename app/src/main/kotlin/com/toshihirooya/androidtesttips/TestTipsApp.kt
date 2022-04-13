package com.toshihirooya.androidtesttips

import android.app.Application

/**
 * アプリケーションクラス
 * Created by toshihirooya on 2017/12/12.
 */
class TestTipsApp : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}