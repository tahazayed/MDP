package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityLunchaerBinding

class ShopByCategoriesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLunchaerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLunchaerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}