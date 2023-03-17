package com.example.ass1

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ass1.databinding.ActivityAddContactBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddContact : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore

        binding.button.setOnClickListener {
            if (binding.name.text != null
            ) {



                var name = binding.name.text.toString();


                val user = hashMapOf(
                    "name" to "$name"
                )
                val i = Intent(this,MainActivity::class.java)
                startActivity(i)

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Log.e("TAG", "Added Successfully")
                        binding.name.text?.clear()




                    }


            }
        }

    }


}