package com.example.afinal

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.afinal.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityJoinBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)
        auth = Firebase.auth

        binding.Joinbtn.setOnClickListener{

            var isGoToJoin = true

            val email = binding.EmailArea.text.toString()
            val password1 = binding.PasswordArea1.text.toString()
            val password2 = binding.PasswordArea2.text.toString()
            val spinner = findViewById<Spinner>(R.id.Uni)

            spinner.adapter=ArrayAdapter.createFromResource(this,R.array.university,android.R.layout.simple_dropdown_item_1line)


            if(email.isEmpty()){
                Toast.makeText(this,"Enter your Email",Toast.LENGTH_LONG).show()
                isGoToJoin = false

            }
            if(password1.isEmpty()){
                Toast.makeText(this,"Enter your Password",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password2.isEmpty()){
                Toast.makeText(this,"Enter your Password",Toast.LENGTH_LONG).show()
                isGoToJoin = false

            }
            if(!password1.equals(password2)){
                Toast.makeText(this,"not same password",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password1.length<6){
                Toast.makeText(this,"plese password with 6 digits or more",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(isGoToJoin){
                auth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
                            Toast.makeText(this,"Success Check your email",Toast.LENGTH_LONG).show()

                            val intent = Intent(this,MainActivity::class.java)
                            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)

                        } else {
                            //Toast.makeText(this,"fail",Toast.LENGTH_LONG).show()
                            Toast.makeText(this,"fail",Toast.LENGTH_LONG).show()
                        }
                    }



            }

            }




        }



    }