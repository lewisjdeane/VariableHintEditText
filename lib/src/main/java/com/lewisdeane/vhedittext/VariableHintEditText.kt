package com.lewisdeane.vhedittext

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class VariableHintEditText(
    context: Context,
    attrs: AttributeSet
) : AppCompatEditText(context, attrs) {

    /** The hints specified by the user in the 'hints' XML attribute. */
    private val hints = mutableListOf<String>()

    /** The hint prefix specified by the user in the 'hint_prefix' XML attribute. */
    private var hintPrefix = ""

    init {
        val styledAttrs =
            context.theme.obtainStyledAttributes(attrs, R.styleable.VariableHintEditText, 0, 0)
        val hintsResId = styledAttrs.getResourceId(R.styleable.VariableHintEditText_hints, -1)
        hintPrefix = styledAttrs.getString(R.styleable.VariableHintEditText_hints_prefix) ?: ""

        if (hintsResId != -1) {
            val hintsArray = resources.obtainTypedArray(hintsResId)
            (0 until hintsArray.length()).forEach { index ->
                hintsArray.getString(index)?.let { hints.add(it) }
            }
            hintsArray.recycle()

            // Initialise the EditText with a random hint.
            refreshHint()
        }

        styledAttrs.recycle()
    }

    /** Set a new hint in the EditText, picked randomly from the list. */
    fun refreshHint() {
        if (hints.isNotEmpty()) {
            val randomIndex = (0 until hints.size).random()
            hint = "$hintPrefix ${hints[randomIndex]}".trim()
        }
    }
}