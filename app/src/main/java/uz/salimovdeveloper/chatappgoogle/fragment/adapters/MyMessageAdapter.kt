package uz.salimovdeveloper.chatappgoogle.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.salimovdeveloper.chatappgoogle.databinding.FromMessageBinding
import uz.salimovdeveloper.chatappgoogle.databinding.ToMessageBinding
import uz.salimovdeveloper.chatappgoogle.fragment.models.MyMessage

class MyMessageAdapter(val uid: String, val list: List<MyMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ToVh(val toMessageBinding: ToMessageBinding) :
        RecyclerView.ViewHolder(toMessageBinding.root) {
        fun onBind(myMessage: MyMessage) {
            toMessageBinding.toMessage.text = myMessage.text
            toMessageBinding.toDate.text = myMessage.date
        }
    }

    inner class FromVh(val fromMessageBinding: FromMessageBinding) :
        RecyclerView.ViewHolder(fromMessageBinding.root) {
        fun onBind(myMessage: MyMessage) {
            fromMessageBinding.fromMessage.text = myMessage.text
            fromMessageBinding.fromDate.text = myMessage.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            ToVh(ToMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            FromVh(FromMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0){
            val myholder = holder as ToVh
            myholder.onBind(list[position])
        }else{
            val myholder = holder as FromVh
            myholder.onBind(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return if (list[position].fromUid == uid)
            0
        else
            1
    }
}