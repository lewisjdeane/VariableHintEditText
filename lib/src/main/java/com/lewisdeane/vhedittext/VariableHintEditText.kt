package com.lewisdeane.vhedittext

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class VariableHintEditText(
    context: Context,
    attrs: AttributeSet
) : AppCompatEditText(context, attrs) {

    init {
        val styledAttrs =
            context.theme.obtainStyledAttributes(attrs, R.styleable.VariableHintEditText, 0, 0)
        val hintsResId = styledAttrs.getResourceId(R.styleable.VariableHintEditText_hints, -1)

        if (hintsResId != -1) {
            val hints = mutableListOf<String>()

            val hintsArray = resources.obtainTypedArray(hintsResId)
            (0 until hintsArray.length()).forEach { index ->
                hintsArray.getString(index)?.let { hints.add(it) }
            }
            hintsArray.recycle()

            if (hints.isNotEmpty()) {
                val hintPrefix =
                    styledAttrs.getString(R.styleable.VariableHintEditText_hints_prefix) ?: ""
                val randomIndex = (0 until hints.size).random()
                hint = "$hintPrefix ${hints[randomIndex]}".trim()
            }
        }

        styledAttrs.recycle()
    }
}