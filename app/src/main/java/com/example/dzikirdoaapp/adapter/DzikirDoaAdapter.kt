package com.example.dzikirdoaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dzikirdoaapp.databinding.EachItemBinding
import com.example.dzikirdoaapp.model.DzikirDoaModel

class DzikirDoaAdapter(val listDzikirDoa: ArrayList<DzikirDoaModel>) : RecyclerView.Adapter<DzikirDoaAdapter.ViewHolder>() {
    class ViewHolder(var binding: EachItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        EachItemBinding.inflate(LayoutInflater.from(parent.context)
        , parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvDesc.text = listDzikirDoa[position].desc
        holder.binding.tvLafaz.text = listDzikirDoa[position].lafaz
        holder.binding.tvTerjemah.text = listDzikirDoa[position].terjemah
    }

    override fun getItemCount() = listDzikirDoa.size
}