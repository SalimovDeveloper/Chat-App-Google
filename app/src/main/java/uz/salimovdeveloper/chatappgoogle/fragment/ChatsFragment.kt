package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {
    private lateinit var binding: FragmentChatsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatsBinding.inflate(layoutInflater)

        return binding.root
    }
}