package com.example.kampustangerang

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kampustangerang.data.AppDatabase
import com.example.kampustangerang.data.User
import com.example.kampustangerang.databinding.ActivitySignupBinding
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)

        // Setup Spinner Kelas
        val classes = arrayOf("Kelas 10", "Kelas 11", "Kelas 12")
        binding.spClass.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, classes)

        // Setup Spinner Peminatan
        val interests = arrayOf("IPA", "IPS", "Bahasa")
        binding.spInterest.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, interests)

        binding.btnRegister.setOnClickListener {
            val username = binding.etRegUsername.text.toString()
            val school = binding.etRegSchool.text.toString()
            val userClass = binding.spClass.selectedItem.toString()
            val interest = binding.spInterest.selectedItem.toString()
            val password = binding.etRegPassword.text.toString()

            if (username.isNotEmpty() && school.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    val newUser = User(
                        username = username,
                        school = school,
                        userClass = userClass,
                        interest = interest,
                        password = password
                    )
                    db.userDao().registerUser(newUser)
                    Toast.makeText(this@SignUpActivity, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvToLogin.setOnClickListener {
            finish()
        }
    }
}
