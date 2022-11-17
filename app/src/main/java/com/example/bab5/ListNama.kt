package com.example.bab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListNama : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_nama)
        val todoVM = TodoViewModel()
        val adapter = TodoAdapter(todoVM.getTodos())
        val rvTodo = findViewById<RecyclerView>(R.id.rv_todo)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)




        val tombol_ke_menu = findViewById<Button>(R.id.button)
        tombol_ke_menu.setOnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

    }
}