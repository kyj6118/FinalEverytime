package com.example.afinal.board

import android.R.attr
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bokchi.mysolelife.utils.FBRef
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.afinal.R
import com.example.afinal.VO.FBAuth
import com.example.afinal.VO.board
import com.example.afinal.databinding.ActivityBoardWriteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.net.FileNameMap
import java.util.jar.Attributes


/*
class BoardWriteActivity : AppCompatActivity() {

    private val GET_GALLERY_IMAGE = 200


    private val TAG = BoardWriteActivity::class.java.simpleName

    private var isImageUpload = false
    var firestore : FirebaseFirestore? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityBoardWriteBinding



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()

        val db = Firebase.firestore




    binding.writeBtn.setOnClickListener {


            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()
            val email = FBAuth.getemail()

            val key = FBRef.boardRef.push().key.toString()
            // val image1 =



            FBRef.boardRef
                .child(key)
                .setValue(board(title, content, time, email, uid))



            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()
            finish()


            Log.d(TAG, title)
            Log.d(TAG, content)

            val board = hashMapOf(
                "title" to title,
                "contents" to content,
                "id" to uid,
                "email" to email,
                "time" to time,

            )
            // 파이어베이스 store에 이미지를 저장하고 싶습니다
            // 만약에 내가 게시글을 클릭했을 때, 게시글에 대한 정보를 받아와야 하는데
            // 이미지 이름에 대한 정보를 모르기 때문에
            // 이미지 이름을 문서의 key값으로 해줘서 이미지에 대한 정보를 찾기 쉽게 해놓음.



            db.collection("board")
                .document(key)
                .set(board)
                .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }

            Toast.makeText(this,"Sucess write board",Toast.LENGTH_LONG).show()
            finish()

            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()

            if(isImageUpload == true) {
                imageUpload()
            }

            finish()


        }

        binding.imageArea1.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 100)
            isImageUpload = true
        }
        binding.imageArea2.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 101)
            isImageUpload = true
        }
        binding.imageArea3.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 102)
            isImageUpload = true
        }
        binding.imageArea4.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 103)
            isImageUpload = true
        }

    }

    private fun imageUpload(){
        // Get the data from an ImageView as bytes


        val storage = Firebase.storage
        val storageRef = storage.reference
        val mountainsRef = storageRef.child("")



        val imageView = binding.imageArea1
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()







        var uploadTask = mountainsRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
        }

    }


     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)


         if(resultCode == RESULT_OK && requestCode == 100) {

             binding.imageArea1.setImageURI(data?.data)



         }

             if(resultCode == RESULT_OK && requestCode == 101) {

                 binding.imageArea2.setImageURI(data?.data)
             }

         if(resultCode == RESULT_OK && requestCode == 102) {
             binding.imageArea3.setImageURI(data?.data)
         }

         if(resultCode == RESULT_OK && requestCode == 103) {
             binding.imageArea4.setImageURI(data?.data)
         }





     }



}*/
