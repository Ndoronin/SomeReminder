package com.example.somereminder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val names: List<String>):
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        // val currentItem = expenseList[position]
        holder.largeTextView.text = names[position]
        holder.smallTextView.text = "кот"
        /* holder.rowLayout.setOnClickListener {

             holder.itemView.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToExpenseEditFragment(currentItem))
         }*/
    }


    override fun getItemCount() = names.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)


    }
}

