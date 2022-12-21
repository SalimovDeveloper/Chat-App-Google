package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentUsersBinding
import uz.salimovdeveloper.chatappgoogle.fragment.adapters.RvAdapter
import uz.salimovdeveloper.chatappgoogle.fragment.adapters.RvClick
import uz.salimovdeveloper.chatappgoogle.fragment.models.User
import uz.salimovdeveloper.chatappgoogle.fragment.models.Users

class UsersFragment : Fragment(), RvClick{
    private lateinit var binding: FragmentUsersBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var userReference: DatabaseReference
    private lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(layoutInflater)

        database = FirebaseDatabase.getInstance()
        userReference = database.getReference("users")

        rvAdapter = RvAdapter(this@UsersFragment , ArrayList())
        binding.rv.adapter = rvAdapter

        loadData()


        return binding.root
    }

    private fun loadData() {
        userReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                for (child in children) {
                    val value = child.getValue(Users::class.java)
                    if (value!=null){

                        rvAdapter.list.add(value)
                    }
                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Cancel", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun NameClick(users: Users) {
        findNavController().navigate(R.id.chatsFragment, bundleOf("key" to users))
    }

    override fun ImageClick(users: Users) {
        findNavController().navigate(R.id.imageViewFragment, bundleOf("key" to users))
    }

}