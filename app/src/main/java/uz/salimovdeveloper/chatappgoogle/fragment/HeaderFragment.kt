package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentHeaderBinding
import uz.salimovdeveloper.chatappgoogle.fragment.models.MyData
import uz.salimovdeveloper.chatappgoogle.fragment.models.User

class HeaderFragment : Fragment() {
    private lateinit var binding: FragmentHeaderBinding
    private lateinit var user: User
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeaderBinding.inflate(layoutInflater)



        return binding.root
    }
}