package com.example.afinal.board

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.afinal.R
import com.example.afinal.VO.FBAuth
import com.example.afinal.databinding.ActivityBoardWriteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BoardWriteActivity : AppCompatActivity() {


    var firestore : FirebaseFirestore? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityBoardWriteBinding
    private val TAG =BoardWriteActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R .layout.activity_board_write)

        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()
        val db = Firebase.firestore



        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_write)

        binding.wirteBtn.setOnClickListener{

            val title=binding.titleArea.text.toString()
            val content=binding.contentArea.text.toString()
            val uid=FBAuth.getUid()
            val email=FBAuth.getemail()
            val time=FBAuth.getTime()

            Log.d(TAG,title)
            Log.d(TAG,content)

            val board = hashMapOf(
                "title" to title,
                "contents" to content,
                "id" to uid,
                "email" to email,
                "time" to time

            )

            db.collection("board").document()
                .set(board)
                .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }

            Toast.makeText(this,"Sucess write board",Toast.LENGTH_LONG).show()
            finish()

        }


    }
}