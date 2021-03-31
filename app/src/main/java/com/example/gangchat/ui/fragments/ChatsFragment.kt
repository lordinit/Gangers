package com.example.gangchat.ui.fragments

import androidx.fragment.app.Fragment
import com.example.gangchat.R
import com.example.gangchat.utilits.APP_ACTIVITY


class ChatsFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Чаты"
    }

}