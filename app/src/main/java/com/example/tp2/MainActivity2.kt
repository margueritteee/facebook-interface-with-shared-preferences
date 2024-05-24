package com.example.tp2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val pref=getSharedPreferences("bdd", Context.MODE_PRIVATE)
        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener{
            pref.edit {
                putBoolean("connected",false)
            }
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}