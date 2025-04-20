package com.example.e_commerce_app_using_jetpackcompose.ViewModel

import androidx.lifecycle.ViewModel
import com.example.e_commerce_app_using_jetpackcompose.model.userModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class AuthViewModel: ViewModel(){

    private val auth = Firebase.auth
    private val firestore = Firebase.firestore


    fun signup(email:String,name:String,password:String,onResult:(Boolean,String?) ->Unit ){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    var userId = it.result?.user?.uid
                    val userModel = userModel(email,name,userId!!)
                    firestore.collection("users").document(userId)
                        .set(userModel)
                        .addOnCompleteListener{ dbTask ->
                            if(dbTask.isSuccessful){
                                onResult(true,null)
                            }else{
                                onResult(false,"Some Thing Went Wrong")
                            }
                        }

                }else{
                    onResult(false,it.exception?.localizedMessage)
                }
            }
    }


    fun login(){}


}