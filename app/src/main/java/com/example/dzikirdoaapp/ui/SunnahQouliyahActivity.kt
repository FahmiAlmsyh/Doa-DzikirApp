package com.example.dzikirdoaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dzikirdoaapp.R
import com.example.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.example.dzikirdoaapp.databinding.ActivitySunnahQouliyahBinding
import com.example.dzikirdoaapp.model.DataDzikirDoa
import com.example.dzikirdoaapp.model.DzikirDoaModel

class SunnahQouliyahActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySunnahQouliyahBinding
    private val listDzikirQouliyah: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunnahQouliyahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.rvSunnahQouliyah){
            layoutManager = LinearLayoutManager(this@SunnahQouliyahActivity)
            adapter = DzikirDoaAdapter(listDzikirQouliyah)
        }

        initData()

    }

    private fun initData() {
        val dzikirQouliyah = DataDzikirDoa.listQauliyah
        listDzikirQouliyah.addAll(dzikirQouliyah)
    }

}