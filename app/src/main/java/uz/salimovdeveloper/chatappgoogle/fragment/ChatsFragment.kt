package uz.salimovdeveloper.chatappgoogle.fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import uz.salimovdeveloper.chatappgoogle.R
import uz.salimovdeveloper.chatappgoogle.databinding.FragmentChatsBinding
import uz.salimovdeveloper.chatappgoogle.fragment.adapters.MyFragmentAdapter
import uz.salimovdeveloper.chatappgoogle.fragment.adapters.MyMessageAdapter
import uz.salimovdeveloper.chatappgoogle.fragment.models.MyMessage
import uz.salimovdeveloper.chatappgoogle.fragment.models.Users

class ChatsFragment : Fragment() {
    private lateinit var binding: FragmentChatsBinding
    private lateinit var users: Users
    private lateinit var referenceMessage: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var myMessageAdapter: MyMessageAdapter
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatsBinding.inflate(layoutInflater)

        users = arguments?.getSerializable("key") as Users


        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        firebaseDatabase = FirebaseDatabase.getInstance()

        referenceMessage = firebaseDatabase.getReference("message")

        auth = FirebaseAuth.getInstance()

        referenceMessage.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<MyMessage>()
                for (child in snapshot.children) {
                    val value = child.getValue(MyMessage::class.java)
                    if (value != null) {
                        if (((value.fromUid==auth.uid) && (value.toUid==users.uid)) || (value.fromUid==users.uid && value.toUid ==auth.uid))
                        list.add(value)
                    }
                }
                myMessageAdapter = MyMessageAdapter(auth.uid!!, list)
                binding.rv.adapter = myMessageAdapter
                binding.rv.scrollToPosition(list.size-1)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()

            }
        })

        binding.nameUser.text = users.displayName.toString()

        binding.sendBtn.setOnClickListener {
            val myMessage = MyMessage(binding.myMessage.text.toString().trim(), fromUid = auth.uid!!, toUid = users.uid!!)
            val key = referenceMessage.push().key
            referenceMessage.child(key!!).setValue(myMessage)
            Toast.makeText(requireContext(), "Send", Toast.LENGTH_SHORT).show()
            binding.myMessage.text.clear()

        }

        return binding.root
    }
}