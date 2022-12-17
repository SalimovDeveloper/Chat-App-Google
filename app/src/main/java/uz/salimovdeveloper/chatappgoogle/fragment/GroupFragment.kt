package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentGroupBinding

class GroupFragment : Fragment() {
    private lateinit var binding: FragmentGroupBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupBinding.inflate(layoutInflater)

        return binding.root
    }
}