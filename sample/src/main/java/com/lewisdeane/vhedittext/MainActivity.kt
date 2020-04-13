package com.lewisdeane.vhedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTexts = listOf(editText1, editText2, editText3)

        refresh.setOnClickListener {
            editTexts.forEach { it.refreshHint() }
        }
    }
}
