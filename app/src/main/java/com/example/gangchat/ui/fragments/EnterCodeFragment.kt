package com.example.gangchat.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gangchat.R
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code)
{
    override fun onStart()
    {
        super.onStart()
        register_input_code.addTextChangedListener(object :TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
            {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
            {

            }

            override fun afterTextChanged(s: Editable?)
            {
                val string:String = register_input_code.text.toString()
                if (string.length==6)
                {
                    verifieCode()
                }
            }
        })
    }
    fun verifieCode(){
        Toast.makeText(activity,"Ok",Toast.LENGTH_SHORT).show()

    }
}