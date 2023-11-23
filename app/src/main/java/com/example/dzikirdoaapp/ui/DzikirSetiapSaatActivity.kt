package com.example.dzikirdoaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dzikirdoaapp.R
import com.example.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.example.dzikirdoaapp.databinding.ActivityDzikirSetiapSaatBinding
import com.example.dzikirdoaapp.model.DataDzikirDoa
import com.example.dzikirdoaapp.model.DzikirDoaModel

class DzikirSetiapSaatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirSetiapSaatBinding
    private val listDzikirSetiapSaat: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.rvDzikirSetiapSaat){
            layoutManager = LinearLayoutManager(this@DzikirSetiapSaatActivity)
            adapter = DzikirDoaAdapter(listDzikirSetiapSaat)
        }

        initData()
    }

    private fun initData() {
        val dzikirSetiapSaat = DataDzikirDoa.listDzikir
        listDzikirSetiapSaat.addAll(dzikirSetiapSaat)
    }
}