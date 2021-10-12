package ru.surf.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StringListAdapter(private val stringList: List<String>) :
    RecyclerView.Adapter<StringListAdapter.StringViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_string, parent, false)

        return StringViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.bind(stringList[position])
    }

    class StringViewHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        private val rvItem: TextView = view.findViewById(R.id.rv_item)
        fun bind(string: String) {
            rvItem.text = string
        }
    }
}