package com.toshihirooya.androidtesttips

import io.reactivex.Single
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 *
 * Created by t-oya on 2017/12/12.
 */
open class SampleRepositoryTest {

    @Before
    fun setUp() {

    }

    @Test
    fun `リポジトリがキャッシュしてるかのテスト`() {
        val mockSamplePreference = mock(SamplePreferences::class.java)
        val repository = SampleRepository(mockSamplePreference)

        repository.putString("test data")
        Assert.assertEquals("test data", repository.cache[repository.PREF_KEY])
    }

    @Test
    fun `リポジトリがキャッシュをつかってるかのテスト`() {
        val mockSamplePreference = mock(SamplePreferences::class.java).apply {
            `when`(getPrefString("pref_key")).thenReturn(Single.just("LocalData"))
        }
        val repository = SampleRepository(mockSamplePreference)

        repository.putString("CashData")

        repository.getString().subscribe({ output ->
            Assert.assertEquals("CashData", output)
        }, {})
    }

    @Test
    fun `リポジトリがキャッシュを保持していない場合に取得するかのテスト`() {
        val mockSamplePreference = mock(SamplePreferences::class.java).apply {
            `when`(getPrefString("pref_key")).thenReturn(Single.just("LocalData"))
        }
        val repository = SampleRepository(mockSamplePreference)

        repository.getString().subscribe({ output ->
            Assert.assertEquals("LocalData", output)
        }, {})
    }
}