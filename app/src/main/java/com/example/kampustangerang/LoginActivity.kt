package com.example.kampustangerang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kampustangerang.data.AppDatabase
import com.example.kampustangerang.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    val user = db.userDao().login(username, password)
                    if (user != null) {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("USERNAME", user.username)
                        intent.putExtra("SCHOOL", user.school)
                        intent.putExtra("CLASS", user.userClass)
                        intent.putExtra("INTEREST", user.interest)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvToSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
