package com.example.gangchat.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.gangchat.MainActivity
import com.example.gangchat.R
import com.example.gangchat.activites.RegisterActivity
import com.example.gangchat.utilits.AUTH
import com.example.gangchat.utilits.USER
import com.example.gangchat.utilits.replaceActivity
import com.example.gangchat.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {



    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        settings_phone_number.text = USER.phone
        settings_status.text = USER.status
        settings_user_name.text = USER.username
        setting_btn_change_user_name.setOnClickListener{replaceFragment(ChangeUsernameFragment())}
        setting_btn_change_bio.setOnClickListener{replaceFragment(ChangeBioFragment())}
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}
