package com.example.gangchat.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.gangchat.MainActivity
import com.example.gangchat.R
import com.example.gangchat.utilits.APP_ACTIVITY
import com.example.gangchat.utilits.hideKeyboard


open class BaseChangeFragment (layout:Int): Fragment(layout) {


    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
        (activity as MainActivity).mAppDrawer.disableDrawer()
        hideKeyboard()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.setting_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_confirm_change -> change()
        }
        return true
    }

    open fun change() {

    }
}
