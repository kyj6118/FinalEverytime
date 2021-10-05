package com.example.afinal.evaluate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import com.example.afinal.R
import com.example.afinal.VO.evaluate
import com.example.afinal.databinding.ActivityEvaluateBoardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EvaluateBoard : AppCompatActivity() {

    private lateinit var binding : ActivityEvaluateBoardBinding
    var firestore: FirebaseFirestore? = null
    private lateinit var auth: FirebaseAuth
    lateinit var listView: ListView
    private val evaluateList = mutableListOf<evaluate>()
    private val boardKeyList = mutableListOf<String>()





    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluate_board)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_evaluate_board)

        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()
     //   getFBEvaluateData()




        //글쓰기 액티비티 이동
        val ImageView: ImageView = findViewById(R.id.wirteBtn)
        ImageView.setOnClickListener {
            val intent = Intent(this, EvaluateBoardWrite::class.java)
            startActivity(intent)

        }


    }

    /*private fun getFBEvaluateData() {
        evaluateRVAdapter.notifyDataSetChanged()
        evaluateRVAdapter = EvaluateBoardListAdater(evaluateList)
        binding.evaluateListView.adapter = evaluateRVAdapter
        val db = Firebase.firestore

        evaluateList.clear()

        db.collection("evaluateboard")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {


                    evaluateList.add(
                        evaluate
                            (
                            document["title"].toString(),
                            document["professor"].toString()

                        )
                    )

                    boardKeyList.add(document.id.toString())

                }
                evaluateList.reverse()
                evaluateList.reverse()
                evaluateRVAdapter.notifyDataSetChanged()

            }
    }*/
}