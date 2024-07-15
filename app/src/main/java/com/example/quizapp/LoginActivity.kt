package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth =FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener{
            login()
        }
        binding.btnLSignUp.setOnClickListener{
           val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


    private  fun login(){
        val email = binding.etEmailAddress.text.toString()
        val password = binding.etPassword.text.toString()
        
        if (email.isBlank()||password.isBlank()){
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }
        
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            }
            else{
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
            }

    }
}