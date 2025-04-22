package com.example.e_commerce_app_using_jetpackcompose.model

data class ProductModel(
    val id:String = "",
    val title:String = "",
    val description:String ="",
    val price: String = "",
    val actualprice:String = "",
    val category: String = "",
    val images:Array<String> = emptyArray(),

    )
