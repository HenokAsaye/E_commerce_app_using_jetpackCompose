package com.example.e_commerce_app_using_jetpackcompose

import android.content.Context
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

object AppUtill {
    fun showToast(context: Context, message:String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

    fun addItemToCart(productId:String, context:Context){
        val userDoc = Firebase.firestore.collection("users")
            .document(FirebaseAuth.getInstance().currentUser?.uid!!)
        userDoc.get().addOnCompleteListener{
            if(it.isSuccessful){
                val currentCart = it.result.get("cartItems") as? Map<String,Long> ?: emptyMap()
                val currentQuanity = currentCart[productId] ?:0
                val updateQuanity = currentQuanity + 1

                var updatedCart = mapOf("cartItems.$productId" to updateQuanity)
                userDoc.update(updatedCart)
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            showToast(context,"Item added to the cart")
                        }else{
                            showToast(context,"Failed adding item to the cart")
                        }
                    }
            }
        }
    }

}