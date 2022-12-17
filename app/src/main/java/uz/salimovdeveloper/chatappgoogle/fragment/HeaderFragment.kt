package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentHeaderBinding
import uz.salimovdeveloper.chatappgoogle.fragment.models.MyData

class HeaderFragment : Fragment() {
    private lateinit var binding: FragmentHeaderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeaderBinding.inflate(layoutInflater)

        val name = MyData.name.toString()

        binding.nameHeader.text = name

//        MyData.name = binding.nameHeader.text.toString()

        return binding.root
    }
}