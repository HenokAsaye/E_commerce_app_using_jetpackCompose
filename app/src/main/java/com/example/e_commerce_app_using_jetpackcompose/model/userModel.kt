package com.example.e_commerce_app_using_jetpackcompose.model

data class userModel(
    val email :String = "",
    val name:String = "",
    val uid :String = "",
    val cartItems: Map<String,Long> = emptyMap()
)
