package security.sample.itemlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item.view.*
import security.sample.R
import security.sample.data.Item

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View?
        get() = itemView
}

class ItemListAdapter(
    private val onItemClickListener: (Item) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {

    private val items = mutableListOf<Item>()

    fun setData(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return ItemViewHolder(inflater.inflate(R.layout.item, viewGroup))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        val item = items[position]
        viewHolder.itemView.txtName.text = item.name
        viewHolder.itemView.txtHarga.text = item.name
        viewHolder.itemView.setOnClickListener {
            onItemClickListener.invoke(item)
        }
    }
}