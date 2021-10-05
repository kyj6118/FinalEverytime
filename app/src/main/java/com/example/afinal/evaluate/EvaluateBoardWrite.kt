package com.example.afinal.evaluate

import android.content.ContentValues
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.afinal.R
import com.example.afinal.VO.FBAuth
import com.example.afinal.databinding.ActivityEvaluateBoardWriteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EvaluateBoardWrite : AppCompatActivity(){

        var firestore : FirebaseFirestore? = null
        private lateinit var auth: FirebaseAuth
        private lateinit var binding : ActivityEvaluateBoardWriteBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluate_board_write)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_evaluate_board_write)

        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()
        val db = Firebase.firestore

        binding.writeBtn.setOnClickListener {

            val title = binding.classArea.text.toString()
            val content = binding.contentArea.text.toString()
            val professor = binding.professorArea.text.toString()
            val rating = binding.classRating.rating.toFloat()
            val uid = FBAuth.getUid()
            val email = FBAuth.getemail()

            Log.d(TAG, title)
            Log.d(TAG, content)

            val evaluate = hashMapOf(
                "title" to title,
                "contents" to content,
                "id" to email,
                "rating" to rating,
                "professor" to professor
            )

            db.collection("evaluateboard")
                .document()
                .set(evaluate)
                .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }

            Toast.makeText(this,"Sucess write board", Toast.LENGTH_LONG).show()
            finish()

            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()


            finish()

        }

    }
}