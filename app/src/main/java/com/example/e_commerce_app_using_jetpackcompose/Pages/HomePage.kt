package com.example.e_commerce_app_using_jetpackcompose.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.e_commerce_app_using_jetpackcompose.components.Banner
import com.example.e_commerce_app_using_jetpackcompose.components.Header

@Composable


fun Homepage(modifier: Modifier=Modifier){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(modifier)
        Banner(modifier)
    }
}