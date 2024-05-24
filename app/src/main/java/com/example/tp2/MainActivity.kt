package com.example.tp2
//idee de la langue (fr et ar) dans le dossier Strings
//      l'idee de mode portrait dans le dossier manifest
//      kezrane margueritte g2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.edit
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref=getSharedPreferences("bdd", Context.MODE_PRIVATE)
        val connected=pref.getBoolean("connected",false)//lazm nfs key w false par defaut msh connecti
        if(connected){
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }


        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.button)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                showError(getString(R.string.error))
            }
            else {
                if(email=="admin" && password=="admin"){
                    pref.edit {
                        putBoolean("connected",true)
                    } //hadi khatra lwla
                    val intent= Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.help -> {
                    // leads us to help page
                    true
                }
                R.id.exit -> {
                    // nkhrjo mel app
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


