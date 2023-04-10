package com.catalyst.mytodolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(private val lists: ArrayList<TaskList>, val clickListener: TodoListClickListener): RecyclerView.Adapter<TodoListViewHolder>() {

    interface TodoListClickListener {
        fun listItemClicked(list:TaskList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        //this is to return each viewholder
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        //this is to return the number of rows
     return lists.size
    }


    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        //this is to customise each row according to my data which is customise the view
        holder.listPositionTextView.text = (position + 1).toString()
//        holder.listTitleTextView.text = todoLists[position]
        holder.listTitleTextView.text = lists[position].name
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }

    }

    fun addList(list: TaskList) {
      lists.add(list)
        notifyItemInserted(lists.size-1)
    }
}