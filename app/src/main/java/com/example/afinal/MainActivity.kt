package com.example.afinal

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.afinal.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class  MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var auth: FirebaseAuth



    //private const val TAG = "GoogleActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //     setContentView(R.layout.activity_main)


        auth = Firebase.auth

        //firebase auth 객체
        firebaseAuth = FirebaseAuth.getInstance()



        /*if(auth.currentUser?.uid!==null){
            Log.d("mainActivity","not null")
                startActivity(Intent(this,MainPageActivity::class.java))
                finish()
            }*/








        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.Loginbtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        binding.Joinbtn.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)

        }



    }


}
