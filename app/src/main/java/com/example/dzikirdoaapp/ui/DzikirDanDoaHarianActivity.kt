package com.example.dzikirdoaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dzikirdoaapp.R
import com.example.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.example.dzikirdoaapp.databinding.ActivityDzikirDanDoaHarianBinding
import com.example.dzikirdoaapp.model.DataDzikirDoa
import com.example.dzikirdoaapp.model.DzikirDoaModel

class DzikirDanDoaHarianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirDanDoaHarianBinding
    private val listDzikirDoaHarian: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirDanDoaHarianBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir & Doa Harian"
        setContentView(binding.root)



        with(binding.rvDailyPrayers){
            layoutManager = LinearLayoutManager(this@DzikirDanDoaHarianActivity)
            adapter = DzikirDoaAdapter(listDzikirDoaHarian)

            initData()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (i in desc.indices){
            val dzikir = DzikirDoaModel(
                desc[i],
                lafaz[i],
                terjemah[i],
            )
            listDzikirDoaHarian.add(dzikir)
        }
    }
}