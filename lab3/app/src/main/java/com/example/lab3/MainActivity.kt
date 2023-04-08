package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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

        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                try {
                    // result object contains the intent and RESULT_OK or RESULT_CANCEL
                    if (result.resultCode == Activity.RESULT_OK) {
                        var user = result.data?.getSerializableExtra("user") as User
                        var userExists = false
                        for (u in ob) {
                            if (u.email == user!!.email) {
                                userExists = true
                                break
                            }
                        }
                        if(!userExists){
                            ob.add(user)
                            Toast.makeText(this, "User added successfully you can login: ${user.email}", Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(this, "User with email ${user.email} already exists", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "User cancelled the account creation", Toast.LENGTH_LONG).show()
                    }
                } catch (e: NullPointerException) {
                    Toast.makeText(this, "NullPointerException", Toast.LENGTH_LONG)
                }

            }

        binding.createAccountBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)

            resultContracts.launch(intent)
        }

        binding.loginBtn.setOnClickListener {
            var username = binding.textEmail?.text.toString()

            var password = binding.textPassword?.text.toString()

            var userFound = false

            if (username.isNotEmpty() && password.isNotEmpty()) {

                for (user in ob) {

                    if (user.email.lowercase() == username.lowercase()
                        && user.password == password
                    ) {
                        userFound = true

                        val intent = Intent(this, ShoppingActivity::class.java)

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

        binding.forgetPasswordBtn.setOnClickListener {
            var username = binding.textEmail?.text.toString()
            if (username.isNotEmpty()) {
                username = username.lowercase()
                var password: String? = null
                for (u in ob) {
                    if (u.email.lowercase() == username) {
                        password = u.password
                        break
                    }
                }
                if (password != null) {
//                        // this code works as well
//                         val email = Intent(Intent.ACTION_SEND)
//                         email.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(username))
//                         email.putExtra(Intent.EXTRA_SUBJECT, "your password")
//                         email.putExtra(Intent.EXTRA_TEXT, "your password is:$password")
//                         email.type = "message/rfc822"
//                         startActivity(Intent.createChooser(email, "Choose an Email client :"))


                    val email = Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:$username?Subject=your password&body=your password is:$password")
                    )
                    startActivity(Intent.createChooser(email, "Choose an Email client :"))
                } else {
                    Toast.makeText(
                        this,
                        "This email $username is not registered",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(this, "Please fill user email first", Toast.LENGTH_LONG).show()
            }
        }
    }
}


