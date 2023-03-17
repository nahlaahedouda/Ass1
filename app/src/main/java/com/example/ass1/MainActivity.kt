package com.example.ass1

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ass1.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = Firebase.firestore



        val contactsArr = ArrayList<Contact>()
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                Log.e(TAG, "result: $result")
                for (document in result) {
                    contactsArr.add(
                        Contact(
                            document.id,
                            document.getString("name")!!
                        )
                    )
                }

                val adapter = ContactsAdapter(contactsArr)
                binding.recyclerview.layoutManager = LinearLayoutManager(this)
                binding.recyclerview.adapter = adapter


            }


        binding.add.setOnClickListener {
            val i = Intent(this,AddContact::class.java)
            startActivity(i)
        }
    }


}