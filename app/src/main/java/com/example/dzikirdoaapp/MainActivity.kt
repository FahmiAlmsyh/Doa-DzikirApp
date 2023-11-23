package com.example.dzikirdoaapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.dzikirdoaapp.adapter.ArtikelAdapter
import com.example.dzikirdoaapp.databinding.ActivityMainBinding
import com.example.dzikirdoaapp.model.ArtikelModel
import com.example.dzikirdoaapp.ui.DzikirDanDoaHarianActivity
import com.example.dzikirdoaapp.ui.DzikirPagidanPetangActivity
import com.example.dzikirdoaapp.ui.DzikirSetiapSaatActivity
import com.example.dzikirdoaapp.ui.SunnahQouliyahActivity
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listArtikel: ArrayList<ArtikelModel> = arrayListOf()
    private lateinit var slideIndicator: Array<ImageView?>
    private lateinit var dateTextView: TextView

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                slideIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }


            slideIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dateTextView = findViewById(R.id.date)

        // Mengambil tanggal dan waktu saat ini
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss")
        val dateTime = dateFormat.format(calendar.time)

        // Update TextView dengan tanggal dan waktu saat ini
        dateTextView.text = dateTime

        setDataArtikel()
        setUpViewPagerArtikel()
        setView()

        val gridLayout = binding.root.findViewById<GridLayout>(R.id.ll_dzikir_doa_shalat)

        // Pastikan bahwa elemen tampilan yang diakses ada di layout XML
        val cardViewSunnah = binding.sunnahQouliyah
        val cardViewDzikirSetiapSaat = binding.DzikirSetiapSaat
        val cardViewDoaHarian = binding.doaHarians
        val cardViewDzikirPagidanPetang = binding.dzikirPagidanPetang

        cardViewDoaHarian.setOnClickListener {
            val intent = Intent(this@MainActivity, DzikirDanDoaHarianActivity::class.java)
            startActivity(intent)
        }

        cardViewSunnah.setOnClickListener {
            val intent = Intent(this@MainActivity, SunnahQouliyahActivity::class.java)
            startActivity(intent)
        }

        cardViewDzikirPagidanPetang.setOnClickListener {
            val intent = Intent(this@MainActivity, DzikirPagidanPetangActivity::class.java)
            startActivity(intent)
        }

        cardViewDzikirSetiapSaat.setOnClickListener {
            val intent = Intent(this@MainActivity, DzikirSetiapSaatActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setDataArtikel() {
        // bagian Artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (data in titleArtikel.indices) {
            val artikel = ArtikelModel(
                imageArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imageArtikel.recycle()
    }

    private fun setView() {
        // setup view artikel
        binding.apply {
            vpArtikel.adapter = ArtikelAdapter(listArtikel)
            vpArtikel.registerOnPageChangeCallback(slidingCallback)
        }

    }

    private fun setUpViewPagerArtikel() {
        val llSliderDots = binding.llSliderDots

        slideIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            slideIndicator[i] = ImageView(this)
            slideIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )


            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(slideIndicator[i], params)
        }

        slideIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}
