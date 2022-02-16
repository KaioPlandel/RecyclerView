package com.plandel.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.plandel.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        var listatarefas = mutableListOf<Tarefa>()

        var tarefa1 = Tarefa("ir ao mercado",false)
        var tarefa2 = Tarefa("compra carne",true)

        listatarefas.add(tarefa1)
        listatarefas.add(tarefa2)

        var adapter = AdapterTarefa(listatarefas)

        var recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        binding.buttonAdd.setOnClickListener{
           val titulo = binding.editTarefa.text.toString()
            val tarefa = Tarefa(titulo,false)
            listatarefas.add(tarefa)
            adapter.notifyItemInserted(listatarefas.size - 1)
        }
    }
}