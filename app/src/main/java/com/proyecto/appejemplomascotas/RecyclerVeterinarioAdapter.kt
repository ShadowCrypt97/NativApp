package com.proyecto.appejemplomascotas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerVeterinarioAdapter(var listaVeterinarios:MutableList<Veterinario>,private val itemClickListener: ClickVeterinario):RecyclerView.Adapter<RecyclerVeterinarioAdapter.MiHolder>(){

    interface ClickVeterinario{
        fun onItemClick(veterinario: Veterinario)
    }
    inner class MiHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var nombres:TextView
        var telefono:TextView
        var ciudad:TextView
        var foto:ImageView

        init {
            nombres = itemView.findViewById(R.id.nombre_veterinario)
            ciudad = itemView.findViewById(R.id.ciudad_veterinario)
            telefono = itemView.findViewById(R.id.celular_veterinario)
            foto = itemView.findViewById(R.id.foto_veterinario)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"Usuario registrado exitosamente",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_veterinario,parent,false)
        return MiHolder(itemView)
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        var veterinario = listaVeterinarios[position]
        holder.nombres.text = veterinario.nombre
        holder.telefono.text = veterinario.telefono
        holder.ciudad.text = veterinario.ciudad
        Glide
            .with(holder.itemView)
            .load(veterinario.foto)
            .into(holder.foto)

        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(veterinario)
        }
    }

    override fun getItemCount(): Int {
        return listaVeterinarios.size
    }
}