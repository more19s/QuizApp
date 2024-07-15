package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityLoginIntroBinding
import com.google.firebase.auth.FirebaseAuth

class LoginIntro : AppCompatActivity() {

    lateinit var binding: ActivityLoginIntroBinding
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        if (auth.currentUser!=null){
            
            redirect("MAIN")
            Toast.makeText(this, "Welcome back! ", Toast.LENGTH_SHORT).show()
        }

        binding.btnGetStarted.setOnClickListener{

            redirect("LOGIN")
        }
    }

    private fun redirect(name:String){

        val intent = when(name){
            "LOGIN" -> Intent(this,LoginActivity::class.java)
            "MAIN" -> Intent(this,MainActivity::class.java)
            else-> throw Exception("Page not found")
        }
        startActivity(intent)
        finish()

    }
}