package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.afinal.databinding.ActivityMainBinding

class  MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   //     setContentView(R.layout.activity_main)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.Loginbtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }

        binding.Joinbtn.setOnClickListener {
            val intent = Intent(this,JoinActivity::class.java)
            startActivity(intent)

        }


    }
}