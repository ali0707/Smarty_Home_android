package com.example.smartyhome

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.row.*
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val calendar = Calendar.getInstance()
        val currentDate: String = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.time)
        val textViewDate: TextView = Date_now
        textViewDate.setText(currentDate)
        preferences= getSharedPreferences("Shared_REF", Context.MODE_PRIVATE)
        val  name =preferences.getString("username","")
        name_home.text = name

        val arraList=ArrayList<Model>()

        arraList.add(Model("Living Room ","4 Devices",R.drawable.livingroom))
        arraList.add(Model("Media Room","6 Devices",R.drawable.mediaroom))
        arraList.add(Model("Bath Room","1 Device",R.drawable.bathroom))
        arraList.add(Model("Bed Room","3 Devices",R.drawable.bedroom))

        val myAdapter=MyAdapter(arraList,this)
        recycleview.layoutManager=LinearLayoutManager(this)
        recycleview.adapter=myAdapter
    }

}
