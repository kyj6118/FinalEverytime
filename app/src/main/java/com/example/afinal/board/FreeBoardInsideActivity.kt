package com.example.afinal.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.bokchi.mysolelife.utils.FBRef
import com.bumptech.glide.Glide
import com.example.afinal.R
import com.example.afinal.VO.FBAuth
import com.example.afinal.VO.board
import com.example.afinal.databinding.ActivityFreeBoardBinding
import com.example.afinal.databinding.ActivityFreeBoardInsideBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.ArrayList

class FreeBoardInsideActivity : AppCompatActivity() {

    private val TAG = FreeBoardInsideActivity::class.java.simpleName

    private lateinit var binding: ActivityFreeBoardInsideBinding

    private lateinit var key : String

    var firestore : FirebaseFirestore? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_free_board_inside)

      // 첫번째 방법
        val title = intent.getStringExtra("title").toString()
        val content = intent.getStringExtra("content").toString()
        val time = intent.getStringExtra("time").toString()
        val name = intent.getStringExtra("name").toString()
        binding.titleArea.text = title
        binding.textArea.text = content
        binding.timeArea.text = time
        binding.nameArea.text = name



        // 두번째 방법
        key = intent.getStringExtra("key").toString()
        getImageData(key.toString())



        binding.boardSettingIcon.setOnClickListener {
            showDialog()
        }

    }

    private fun getImageData(key: String) {

        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference.child(key + ".png")

        // ImageView in your Activity
        val imageViewFromFB = binding.getImageArea

        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
            if (task.isSuccessful) {

                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFromFB)

            } else {

            }
        })
    }

    private fun showDialog(){

        val db = Firebase.firestore

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
        val mBuilder =AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("게시글 수정,삭제")

        val alertDialog = mBuilder.show()
        alertDialog.findViewById<Button>(R.id.editBtn)?.setOnClickListener{
            Toast.makeText(this,"aa",Toast.LENGTH_LONG).show()
        }
        alertDialog.findViewById<Button>(R.id.deletBtn)?.setOnClickListener{
            Toast.makeText(this,"bb",Toast.LENGTH_LONG).show()

            db.collection("board").document(key)
                .delete()
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
            finish()
        }


    }



}

