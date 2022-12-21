package uz.salimovdeveloper.chatappgoogle.fragment.adapters

import android.view.View
import uz.salimovdeveloper.chatappgoogle.fragment.models.Users

interface RvClick {

    fun NameClick(users: Users)
    fun ImageClick(users: Users)

}