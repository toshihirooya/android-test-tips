package com.toshihirooya.androidtesttips

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var useCase: SampleUseCase

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as TestTipsApp).component.inject(this)

        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_text)

        findViewById<Button>(R.id.get_button).apply {
            setOnClickListener { getStringFromPref() }
        }
        findViewById<Button>(R.id.put_button).apply {
            setOnClickListener { putStringToPref() }
        }
        findViewById<Button>(R.id.clear_button).apply {
            setOnClickListener { editText.text.clear() }
        }
    }

    private fun getStringFromPref() {
        useCase.get().subscribe({ t: String ->
            editText.setText(t)
        }, {
            // 特に何もしない
        })
    }

    private fun putStringToPref() {
        useCase.put(editText.text.toString())
    }
}
