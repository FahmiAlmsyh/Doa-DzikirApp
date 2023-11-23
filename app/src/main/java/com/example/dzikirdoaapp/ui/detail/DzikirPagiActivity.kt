package com.example.dzikirdoaapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dzikirdoaapp.R
import com.example.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.example.dzikirdoaapp.databinding.ActivityDzikirPagiBinding
import com.example.dzikirdoaapp.model.DataDzikirDoa
import com.example.dzikirdoaapp.model.DzikirDoaModel

class DzikirPagiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPagiBinding
    private val listDzikirPagi: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.rvDzikirPagi){
            layoutManager = LinearLayoutManager(this@DzikirPagiActivity)
            adapter = DzikirDoaAdapter(listDzikirPagi)

            initData()
        }
    }

    private fun initData() {
        val dzikirPagi = DataDzikirDoa.listDzikirPagi
        listDzikirPagi.addAll(dzikirPagi)
    }
}