package com.example.afinal.board

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.afinal.R
import com.example.afinal.VO.FBAuth
import com.example.afinal.VO.board
import com.example.afinal.databinding.ActivityFreeBoardInsideBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class FreeBoardInsideActivity : AppCompatActivity() {

    private val TAG = FreeBoardInsideActivity::class.java.simpleName

    private lateinit var databaseRef : DatabaseReference

    private lateinit var binding: ActivityFreeBoardInsideBinding

    private lateinit var key : String

    var firestore : FirebaseFirestore? = null
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_free_board_inside)


      // 첫번째 방법


        val db = FirebaseFirestore.getInstance()





        // 두번째 방법
        key = intent.getStringExtra("key").toString()
        boardData(key.toString())
        getImageData(key.toString())



        binding.boardSettingIcon.setOnClickListener {
            showDialog()


        }






            }
    private fun boardData(key: String) {
        val db = Firebase.firestore
        val docRef = db.collection("board").document(key)



        docRef
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")


                    binding.titleArea.setText(document.get("title").toString())
                    binding.nameArea.setText(document.get("email").toString())
                    binding.timeArea.setText(document.get("time").toString())
                    binding.textArea.setText(document.get("contents").toString())

                    val myUid = FBAuth.getUid()
                    val writeUid = document.get("id").toString()

                    if(myUid.equals(writeUid)){
                        binding.boardSettingIcon.isVisible = true
                    }



                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

    }


    private fun showDialog(){

        val db = Firebase.firestore

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
        val mBuilder =AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("게시글 수정,삭제")



        val alertDialog = mBuilder.show()
        //수정 버튼 누르면

        alertDialog.findViewById<Button>(R.id.editBtn)?.setOnClickListener{
            Toast.makeText(this,"Modify button",Toast.LENGTH_LONG).show()
            val intent = Intent(this,FreeBoardModifyActivity::class.java)
            intent.putExtra("key", key)
            startActivity(intent)
        }


        //삭제버튼 누르
        alertDialog.findViewById<Button>(R.id.deletBtn)?.setOnClickListener{


            db.collection("board").document(key)
                .delete()
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
            Toast.makeText(this,"Success remove",Toast.LENGTH_LONG).show()
            finish()
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
}




