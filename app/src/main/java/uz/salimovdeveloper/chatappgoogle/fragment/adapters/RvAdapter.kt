package uz.salimovdeveloper.chatappgoogle.fragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import uz.salimovdeveloper.chatappgoogle.databinding.ItemRvBinding
import uz.salimovdeveloper.chatappgoogle.fragment.models.MyMessage
import uz.salimovdeveloper.chatappgoogle.fragment.models.Users

class RvAdapter (val rvClick: RvClick, var list: ArrayList<Users> = ArrayList(), val auth: FirebaseAuth, val context: Context) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(users: Users) {

                itemRvBinding.itemName.text = users.displayName
                Picasso.get().load(users.imageLink).into(itemRvBinding.itemImage)
                itemRvBinding.itemName.setOnClickListener {
                    rvClick.NameClick(users)
                }
                itemRvBinding.itemImage.setOnClickListener {
                    rvClick.ImageClick(users)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}