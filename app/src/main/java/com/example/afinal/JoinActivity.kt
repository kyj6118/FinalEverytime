package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import com.example.afinal.databinding.ActivityMainBinding

class JoinActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)


        val spinner = findViewById<Spinner>(R.id.Uni)

        spinner.adapter=ArrayAdapter.createFromResource(this,R.array.university,android.R.layout.simple_dropdown_item_1line)
    }
}