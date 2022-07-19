package developer.abdulahad.homework31.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import developer.abdulahad.homework31.GsonClassItem
import developer.abdulahad.homework31.databinding.ItemRvBinding

class RvAdapter( var list: List<GsonClassItem>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root){
        fun onBind(user : GsonClassItem, position: Int) {
//            Picasso.get().load(user.avatar_url).into(itemRv.imageRv)
            itemRv.tvRv.text = user.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position] , position)
    }

    override fun getItemCount(): Int = list.size
}