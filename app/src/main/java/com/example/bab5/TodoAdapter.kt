package com.example.bab5

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class TodoAdapter(var todos: List<TodoModel>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): TodoViewHolder {


        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items,
                parent, false)
        return TodoViewHolder(view)
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position:
    Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_nama).text = todos[position].nama
            findViewById<TextView>(R.id.tv_nim).text = todos[position].nim
            findViewById<TextView>(R.id.tv_kelas).text = todos[position].kelas
        }
    }
    override fun getItemCount(): Int {
        return todos.size
    }
}