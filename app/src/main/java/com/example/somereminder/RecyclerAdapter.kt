package com.example.somereminder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter():
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var taskList = emptyList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        // val currentItem = expenseList[position]
        val currentItem = taskList[position]
        holder.largeTextView.text = taskList[position].task
        holder.smallTextView.text = taskList[position].date
        /* holder.rowLayout.setOnClickListener {

             holder.itemView.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToExpenseEditFragment(currentItem))
         }*/
    }

    fun setData(tasks: List<Task>){
        this.taskList = tasks
        notifyDataSetChanged()
    }

    override fun getItemCount() = taskList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
    }
}

