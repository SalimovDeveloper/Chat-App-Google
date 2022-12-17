package uz.salimovdeveloper.chatappgoogle.fragment.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.salimovdeveloper.chatappgoogle.fragment.GroupFragment
import uz.salimovdeveloper.chatappgoogle.fragment.UsersFragment

class MyFragmentAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                UsersFragment()
            }
            1 -> {
                GroupFragment()
            }
            else ->{throw Resources.NotFoundException("Boshqa Fragment yoq")}
        }
    }
}