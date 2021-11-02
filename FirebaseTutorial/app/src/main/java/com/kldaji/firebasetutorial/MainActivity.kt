package com.kldaji.firebasetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kldaji.firebasetutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val firebaseDatabaseRoot = FirebaseDatabase.getInstance().reference
    private val textDatabaseReference = firebaseDatabaseRoot.child("text")
    private val userDatabaseReference = firebaseDatabaseRoot.child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setLogout()
        setText()
        registerTextToDatabase()
        dataPrintAll()
    }

    private fun setLogout() {
        binding.btnMainLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
        }
    }

    private fun setText() {
        textDatabaseReference.child("text").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val text = snapshot.getValue(String::class.java)
                binding.tvMain.text = text
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun registerTextToDatabase() {
        binding.btnMainRegister.setOnClickListener {
            if (binding.etMainData.text.toString() != "") {
//                textDatabaseReference.push().setValue(binding.etMainData.text.toString())
                val user = User("nickname", listOf())
//                userDatabaseReference.child("user1").setValue(user)
                val b= userDatabaseReference
                Log.d("MainActivity", "${userDatabaseReference.push().key}")

                val a =userDatabaseReference.child("user1").child("groupList").get().addOnSuccessListener {
                    it.exists()
                    if (it.value == null) {
                        println("MainActivity - 123")
                    }
                }
            }
        }
    }

    private fun dataPrintAll() {
        binding.btnMainPrintAll.setOnClickListener {
            textDatabaseReference.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        Log.d("MainActivity", "${it.getValue(String::class.java)}")
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        }
    }
}
