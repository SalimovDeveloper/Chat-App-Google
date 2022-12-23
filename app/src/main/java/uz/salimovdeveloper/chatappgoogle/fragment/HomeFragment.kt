package uz.salimovdeveloper.chatappgoogle.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentHomeBinding
import uz.salimovdeveloper.chatappgoogle.fragment.adapters.MyFragmentAdapter


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var myFragmentAdapter: MyFragmentAdapter
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnMenu.setOnClickListener {
            binding.draw.open()
        }

        auth = FirebaseAuth.getInstance()

        val navigationText = binding.navView as NavigationView
        val headerView = navigationText.getHeaderView(0)
        val navUsername = headerView.findViewById<TextView>(R.id.name_header)
        navUsername.text = auth.currentUser!!.displayName.toString()

        val img1: ImageView = headerView.findViewById(R.id.image_header) as ImageView
        Picasso.get().load(auth.currentUser!!.photoUrl).into(img1)



        setTab()

        return binding.root
    }


    private fun setTab() {
        myFragmentAdapter = MyFragmentAdapter(requireActivity())

        binding.myViewPager2.adapter = myFragmentAdapter

        binding.tabLayout.tabIconTint = null

        TabLayoutMediator(binding.tabLayout, binding.myViewPager2){
                tab, position ->

            when(position){
                0->{
                    tab.text = "Chats"
                    tab.setIcon(R.drawable.ic_person)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
                }
                1-> {
                    tab.text = "Groups"
                    tab.setIcon(R.drawable.ic_group)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.qoshimcha_rang))
                }
            }

        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.qoshimcha_rang))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }

        })
    }
}

