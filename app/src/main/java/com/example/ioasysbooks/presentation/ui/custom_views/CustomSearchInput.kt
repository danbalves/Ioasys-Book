package com.example.ioasysbooks.presentation.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.ioasysbooks.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.text.isNullOrEmpty as isNullOrEmpty

class CustomSearchInput @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0

): ConstraintLayout(context, attrs, defStyleAttr){

    private val view = LayoutInflater.from(context).inflate(R.layout.custom_search_input, this, true)

    private val input: TextInputEditText by lazy {
        view.findViewById(R.id.search_bar)
    }

    var textChangeListener: (Input: String) -> Unit = {}

    init {

        setLayout(attrs)
        configureInputSearch()
    }

    private fun setLayout(attrs: AttributeSet?){

        attrs?.let { AttributeSet ->

            val attributes = context.obtainStyledAttributes(AttributeSet, R.styleable.CustomSearchInput)

            val customHint = attributes.getString(R.styleable.CustomSearchInput_custom_hint)

            input.hint = customHint

            attributes.recycle()
        }
    }

    private fun configureInputSearch(){

        input.addTextChangedListener { input ->

            configureInputBackground(input.isNullOrEmpty())
            textChangeListener.invoke(toString())

        }

    }

    private fun configureInputBackground(empty: Boolean){
        if(empty)
            input.backgroundTintList = null
        else
            input.backgroundTintList = ContextCompat.getColorStateList(context, android.R.color.white)
    }
}