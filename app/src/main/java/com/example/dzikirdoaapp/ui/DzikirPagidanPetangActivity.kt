package com.example.dzikirdoaapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.dzikirdoaapp.R
import com.example.dzikirdoaapp.ui.detail.DzikirPagiActivity
import com.example.dzikirdoaapp.ui.detail.DzikirPetangActivity

class DzikirPagidanPetangActivity : AppCompatActivity() {

    private lateinit var pagiMove: CardView
    private lateinit var petangMove: CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzikir_pagidan_petang)

        pagiMove = findViewById(R.id.dzikirPagi)
        pagiMove.setOnClickListener{
            val intent = Intent(this@DzikirPagidanPetangActivity, DzikirPagiActivity::class.java)
            startActivity(intent)
        }

        petangMove = findViewById(R.id.DzikrPetang)
        petangMove.setOnClickListener{
            val intent = Intent(this@DzikirPagidanPetangActivity, DzikirPetangActivity::class.java)
            startActivity(intent)
        }

    }
}