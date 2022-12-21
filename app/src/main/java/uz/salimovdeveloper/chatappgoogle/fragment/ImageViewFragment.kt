package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentImageViewBinding
import uz.salimovdeveloper.chatappgoogle.fragment.models.Users

class ImageViewFragment : Fragment() {
    private lateinit var binding: FragmentImageViewBinding
    private lateinit var users: Users
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageViewBinding.inflate(layoutInflater)

        users = arguments?.getSerializable("key") as Users

        Picasso.get().load(users.imageLink).into(binding.imageUser)

        return binding.root
    }
}