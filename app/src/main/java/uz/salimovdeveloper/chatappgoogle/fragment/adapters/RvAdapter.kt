package uz.salimovdeveloper.chatappgoogle.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.salimovdeveloper.chatappgoogle.databinding.ItemRvBinding
import uz.salimovdeveloper.chatappgoogle.fragment.models.User
import uz.salimovdeveloper.chatappgoogle.fragment.models.Users

class RvAdapter (val rvClick: RvClick, var list: ArrayList<Users> = ArrayList()) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(users: Users) {
            itemRvBinding.itemName.text = users.displayName
            Picasso.get().load(users.imageLink).into(itemRvBinding.itemImage)

            itemRvBinding.itemName.setOnClickListener {
                rvClick.ItemClick(users)
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