package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
//        findViewById<TextView>(R.id.mainTvHolaMundo).setText("hola!!!!")
        mainTvHolaMundo?.text = getString(R.string.hello_world)

        mainEditTextHolaMundo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                Log.d("XXX", "edittext change -> "+mainEditTextHolaMundo.text)
                mainBtnHolaMundo.setBackgroundColor(Color.RED)
            }
        })

        // tiene prioridad
        mainBtnHolaMundo.setOnClickListener { v->
            Log.d("XXX", "boton click (listener) v=[$v]")
            mainTvHolaMundo.text = mainEditTextHolaMundo.text
            v.setBackgroundColor(Color.LTGRAY)
        }

    }

    fun onButtonClick(view: View) {
        Log.d("XXX", "boton click (funcion)")
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, mainEditTextHolaMundo.text.toString())
        }
        startActivity(intent)

    }



}