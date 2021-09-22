package com.example.afinal.board

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import com.example.afinal.R
import com.example.afinal.R.layout.activity_free_board
import com.example.afinal.VO.board
import com.example.afinal.databinding.ActivityFreeBoardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class FreeBoardActivity : AppCompatActivity() {


    var firestore : FirebaseFirestore? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityFreeBoardBinding
    lateinit var listView: ListView






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_free_board)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_free_board)


        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()
        val db = Firebase.firestore

        listView=binding.boardListView
        val boardList= ArrayList<board>()


//      데이터 불러오기
        db.collection("board")
            .get()
            .addOnSuccessListener { result->
                for(document in result){
                    boardList.add(board(document["title"].toString(),
                        document["contents"].toString(),
                        document["time"].toString(),
                        document["email"].toString()))
                }

                val adapter = FreeBoardListAdapter(boardList)
                listView.adapter = adapter
            }




        val ImageView : ImageView = findViewById(R.id.wirteBtn)
        ImageView.setOnClickListener{
            val intent = Intent(this, BoardWriteActivity::class.java)
            startActivity(intent)

        }






    }
}
