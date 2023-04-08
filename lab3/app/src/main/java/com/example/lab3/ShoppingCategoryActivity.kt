package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityShoppingcategoryBinding

class ShoppingCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingcategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingcategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}