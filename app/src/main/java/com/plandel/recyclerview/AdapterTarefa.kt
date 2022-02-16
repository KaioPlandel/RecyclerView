package com.plandel.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTarefa(private var listaTarefas: List<Tarefa>): RecyclerView.Adapter<AdapterTarefa.MyViewHolder>() {

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val textTarefa: TextView
         val box: CheckBox

        init {
           textTarefa = itemView.findViewById(R.id.textTarefa)
            box = itemView.findViewById(R.id.boxTarefa)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout_tarefa,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.textTarefa.text = listaTarefas[position].tarefa
        holder.box.isChecked = listaTarefas[position].isChecked
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }
}