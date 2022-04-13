package com.toshihirooya.androidtesttips

import dagger.Component
import javax.inject.Singleton

/**
 *
 * Created by toshihirooya on 2017/12/12.
 */
@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

}