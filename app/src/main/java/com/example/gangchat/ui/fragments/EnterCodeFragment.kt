package com.example.gangchat.ui.fragments

import android.net.wifi.hotspot2.pps.Credential
import androidx.fragment.app.Fragment
import com.example.gangchat.MainActivity
import com.example.gangchat.R
import com.example.gangchat.activites.RegisterActivity
import com.example.gangchat.utilits.AUTH
import com.example.gangchat.utilits.AppTextWatcher
import com.example.gangchat.utilits.replaceActivity
import com.example.gangchat.utilits.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(val PhoneNumber: String,val id: String)
    : Fragment(R.layout.fragment_enter_code)
{


    override fun onStart()
    {
        super.onStart()
        (activity as RegisterActivity).title = PhoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher {
                val string:String = register_input_code.text.toString()
                if (string.length==6)
                {
                    enterCode()
                }
        })
    }
    private fun enterCode(){
        val code = register_input_code.text.toString()
       val credential = PhoneAuthProvider.getCredential(id,code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful){
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(task.exception?.message.toString())
        }
    }
}