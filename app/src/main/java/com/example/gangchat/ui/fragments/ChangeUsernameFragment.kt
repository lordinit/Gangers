package com.example.gangchat.ui.fragments

import com.example.gangchat.R
import com.example.gangchat.utilits.*
import kotlinx.android.synthetic.main.fragment_change_username.*
import java.util.*


class ChangeUsernameFragment : BaseChangeFragment(R.layout.fragment_change_username) {

    lateinit var mNewUsername: String

    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER.username)

    }


    override fun change() {
        mNewUsername = settings_input_username.text.toString().toLowerCase(Locale.getDefault())
        if (mNewUsername.isEmpty()) {
            showToast("поле пустое")
        }else{
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener{
                    if (it.hasChild(mNewUsername)){
                        showToast("Такой ник уже существует")
                    }else {
                        changeUsername()
                    }
                })
        }

    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(CURRENT_UID)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    updateCurrentsUsername()
                }
            }
    }

    private fun updateCurrentsUsername() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_USERNAME)
            .setValue(mNewUsername)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    showToast(getString(R.string.toast_data_update))
                    deleteOldUserName()

                }else
                    showToast(it.exception?.message.toString())
            }
    }

    private fun deleteOldUserName() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    showToast(getString(R.string.toast_data_update))
                    fragmentManager?.popBackStack()
                    USER.username = mNewUsername

                }else   {
                    showToast(it.exception?.message.toString())

                }
            }
    }
}