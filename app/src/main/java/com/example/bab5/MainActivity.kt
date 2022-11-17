package com.example.bab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TodoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nama = findViewById<TextView>(R.id.nama)
        val nim = findViewById<TextView>(R.id.nim)
        val kelas = findViewById<TextView>(R.id.kelas)
        val tombol1 = findViewById<Button>(R.id.button1)
        val tombol2 = findViewById<Button>(R.id.button2)
        val todoVM = TodoViewModel()
        val adapter = TodoAdapter(todoVM.getTodos())
        val rvTodo = findViewById<RecyclerView>(R.id.rv_todo)
        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        tombol1.setOnClickListener {
            val Nama = nama.getText().toString()
            val Nim = nim.getText().toString()
            val Kelas = kelas.getText().toString()
            todoVM.add(TodoModel(Nama, Nim, Kelas))
            rvTodo.adapter = adapter
            rvTodo.layoutManager = LinearLayoutManager(this)
        }
        viewModel.livedatatodos.observe(this) {

            findViewById<TextView>(R.id.highlight).text = it}
        tombol2.setOnClickListener {
            val Nama = nama.getText().toString()
            viewModel.getNama(Nama)
        }

    }

}