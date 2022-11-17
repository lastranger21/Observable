package com.example.bab5

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodoViewModel : ViewModel() {
    private  val  listOfTodos = mutableListOf<TodoModel>()
    private val _livetodos = MutableLiveData<String>()
    val livedatatodos: LiveData<String>get() = _livetodos
    init {
        listOfTodos.add(TodoModel("Narihisago Akihito", "195673840123","Special-Grade"))
        listOfTodos.add(TodoModel("Hijirido Mio", "215852938591","A-Grade"))
    }

    fun getTodos() = listOfTodos
    fun getNama(firstValue: String) {

        _livetodos.value = firstValue
    }
    fun add(new: TodoModel) {
        listOfTodos.add(new)
        getTodos()
    }
}