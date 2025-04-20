package com.example.e_commerce_app_using_jetpackcompose.Pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable


fun CategoryProduct(modifier: Modifier = Modifier, navController: NavHostController){
    Text(text = "Product List")
}