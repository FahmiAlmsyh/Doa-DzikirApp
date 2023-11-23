package com.example.dzikirdoaapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dzikirdoaapp.R
import com.example.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.example.dzikirdoaapp.databinding.ActivityDzikirPetangBinding
import com.example.dzikirdoaapp.model.DataDzikirDoa
import com.example.dzikirdoaapp.model.DzikirDoaModel

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPetangBinding
    private val listDzikirPetang: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.rvDzikirPetang){
            layoutManager = LinearLayoutManager(this@DzikirPetangActivity)
            adapter = DzikirDoaAdapter(listDzikirPetang)

            initData()
        }
    }

    private fun initData() {
        val dzikirPetang = DataDzikirDoa.listDzikirPetang
        listDzikirPetang.addAll(dzikirPetang)
    }
}