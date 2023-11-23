package com.example.dzikirdoaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.dzikirdoaapp.databinding.FragmentArtikelBinding
import com.example.dzikirdoaapp.model.ArtikelModel

class ArtikelAdapter (private val listArtikel: ArrayList<ArtikelModel>):
RecyclerView.Adapter<ArtikelAdapter.ViewHolder>(){
    class ViewHolder(val binding: FragmentArtikelBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentArtikelBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listArtikel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listArtikel[position]

        Glide.with(holder.itemView.context)
            .load(data.imageArtikel)
            .into(holder.binding.imgFragment)
    }
}