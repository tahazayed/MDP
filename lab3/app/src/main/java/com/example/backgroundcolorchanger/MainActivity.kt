package com.example.backgroundcolorchanger

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.backgroundcolorchanger.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btn.setOnClickListener {
           binding.layout.setBackgroundColor(getRandomColor())
        }

        binding.imgBtn.setOnClickListener{
            binding.imgBtn.setBackgroundColor(getRandomColor())
        }
    }

    private fun getRandomColor(): Int {
        val random = Random()

        return Color.argb(255, random.nextInt(256), random.nextInt(256),
            random.nextInt(256))
    }


}