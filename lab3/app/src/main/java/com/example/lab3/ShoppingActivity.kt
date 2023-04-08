package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    private var toast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        val userEmail = intent.getStringExtra("userEmail")

        if (userEmail == null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.textViewEmail.text = userEmail

        binding.imageButtonBooks.setOnClickListener {
            showToast("You have chosen the Books category of shopping")
        }

        binding.imageButtonClothing.setOnClickListener {
            showToast("You have chosen the Clothing category of shopping")
        }

        binding.imageButtonBetterHealth.setOnClickListener {
            showToast("You have chosen the Better Health category of shopping")
        }

        binding.imageButtonAyuveda.setOnClickListener {
            showToast("You have chosen the Ayuveda category of shopping")
        }

    }

    fun showToast(message: String?) {

        toast?.cancel()

        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }
}