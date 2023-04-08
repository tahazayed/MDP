package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var ob: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create 5 default user
        ob = ArrayList<User>()
        ob.add(User("fn1", "ln1", "user1@mail.com", "123456"))
        ob.add(User("fn2", "ln2", "user2@mail.com", "123456"))
        ob.add(User("fn3", "ln3", "user3@mail.com", "123456"))
        ob.add(User("fn4", "ln4", "user4@mail.com", "123456"))
        ob.add(User("fn5", "ln5", "user5@mail.com", "123456"))

        binding.loginBtn.setOnClickListener {
            var username = binding.textEmail.text.toString()
            var password = binding.textPassword.text.toString()

            var userFound = false
            if (username.isNotEmpty() && password.isNotEmpty()) {
                for (user in ob) {
                    if (user.email.lowercase() == username.lowercase()
                        && user.password == password
                    ) {
                        userFound = true
                        val intent = Intent(this, ShoppingCategoryActivity::class.java)
                        intent.putExtra("userEmail", user.email)
                        startActivity(intent)
                        break
                    }
                }
            }
            if (!userFound) {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}


