package com.example.blogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()
        db.collection("Mascotas").document("Raza").get().addOnSuccessListener { document ->
            document?.let {
                Log.d("Firebase","DocumentSnapshot data: ${document.data}")
            }

        }
    }
}