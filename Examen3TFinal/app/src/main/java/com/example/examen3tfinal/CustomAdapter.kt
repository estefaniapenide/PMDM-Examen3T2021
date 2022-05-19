package com.example.examen3tfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.examen3tfinal.databinding.ElementoAzulBinding

class CustomAdapter(private val listaDiscos:MutableList<Album>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(binding: ElementoAzulBinding): RecyclerView.ViewHolder(binding.root){
        val elemento = binding.root
        val titulo =binding.tvTitulo
        val autor = binding.tvAutor
        val caratula =binding.imageView


        init{
            elemento.setOnClickListener {
                Toast.makeText(binding.root.context,"Click en ${titulo.text}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ElementoAzulBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text = listaDiscos[position].titulo
        holder.autor.text = listaDiscos[position].autor
        holder.caratula.setImageResource(listaDiscos[position].caratula)

    }

    override fun getItemCount(): Int {
        return listaDiscos.size
    }

}