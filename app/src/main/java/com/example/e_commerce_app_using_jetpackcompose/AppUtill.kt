package com.example.e_commerce_app_using_jetpackcompose

import android.content.Context
import android.widget.Toast

object AppUtill {
    fun showToast(context: Context, message:String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

}