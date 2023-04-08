package com.example.lab3

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.createAccountBtn.setOnClickListener {
            var firstName = binding.editTextFirstName?.text.toString()
            var lastName = binding.editTextLastName?.text.toString()
            var email = binding.editTextEmail?.text.toString()
            var password = binding.editTextTextPassword?.text.toString()
            if (firstName.isNotEmpty()
                && lastName.isNotEmpty()
                && email.isNotEmpty()
                && password.isNotEmpty()
            ) {
                var user = User(firstName, lastName, email, password)
                val rintent = intent // getIntent()
                val bundle = Bundle()
                bundle.putSerializable("user", user)
                rintent.putExtras(bundle)

                setResult(Activity.RESULT_OK, rintent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all thr fields", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}