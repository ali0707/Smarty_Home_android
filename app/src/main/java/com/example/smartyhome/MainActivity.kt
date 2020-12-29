package com.example.smartyhome

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


lateinit var sharedPreferences :SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        sharedPreferences= getSharedPreferences("Shared_REF",Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("username", "")
        if (name!=null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        entername.setOnClickListener {
            val name:String =NameInput.text.toString()
        val editor:SharedPreferences.Editor=sharedPreferences.edit()
        editor.putString("username",name +"!")
        editor.apply()
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
