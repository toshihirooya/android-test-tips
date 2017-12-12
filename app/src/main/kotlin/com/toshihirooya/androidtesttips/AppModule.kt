package com.toshihirooya.androidtesttips

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * アプリケーションが提供するモジュール
 * Created by toshihirooya on 2017/12/12.
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext
}