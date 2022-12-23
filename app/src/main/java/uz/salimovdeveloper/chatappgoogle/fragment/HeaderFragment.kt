package uz.salimovdeveloper.chatappgoogle.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentHeaderBinding

class HeaderFragment : Fragment() {
    private lateinit var binding: FragmentHeaderBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeaderBinding.inflate(layoutInflater)

        binding.nameHeader.text = "MyDataframe"

        return binding.root
    }
}