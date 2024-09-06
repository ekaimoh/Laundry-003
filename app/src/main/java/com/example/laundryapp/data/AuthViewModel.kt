package com.example.laundryapp.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.laundryapp.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

class AuthViewModel(var navController: NavController,
                    var context: Context
) {
    var mAuth: FirebaseAuth
    init {
        mAuth= FirebaseAuth.getInstance()
    }
    fun signup(fullNames: String,YourJob: String,
               email: String,password: String){
        if (fullNames.isBlank() || YourJob .isBlank()
            || email.isBlank() || password.isBlank()){
            Toast.makeText(context,"Please fill all the fields",
                Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        val userdata= com.example.laundryapp.model.User(
                            fullNames, YourJob,
                            email, password, mAuth.currentUser!!.uid
                        )
                        val regRef = FirebaseDatabase.getInstance().getReference()
                            .child("Users/"+mAuth.currentUser!!.uid)
                        regRef.setValue(userdata).addOnCompleteListener{
                            if (it.isSuccessful){
                                Toast.makeText(context,"Successfully Registered",
                                    Toast.LENGTH_LONG).show()



                            }else{
                                Toast.makeText(context,"${it.exception!!.message}",
                                    Toast.LENGTH_LONG).show()
                            }
                        }

                    }else
                    {
                        navController.navigate(ROUTE_LOGIN)
                    }
                }
        }
    }
    fun login (email: String,password: String){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"Successfully logged in",
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"${it.exception!!.message}",
                    Toast.LENGTH_LONG).show()
            }
        }

    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}


