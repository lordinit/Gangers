package com.example.gangchat.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.gangchat.R
import com.example.gangchat.databinding.ActivityRegisterBinding
import com.example.gangchat.ui.fragments.EnterPhoneNumberFragment
import com.example.gangchat.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityRegisterBinding
    private lateinit var mToolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)

        replaceFragment(EnterPhoneNumberFragment())
    }
}