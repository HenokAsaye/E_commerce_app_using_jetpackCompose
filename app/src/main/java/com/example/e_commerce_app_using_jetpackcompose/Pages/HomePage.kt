package com.example.e_commerce_app_using_jetpackcompose.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_app_using_jetpackcompose.components.Banner
import com.example.e_commerce_app_using_jetpackcompose.components.CategoryView
import com.example.e_commerce_app_using_jetpackcompose.components.Header

@Composable


fun Homepage(modifier: Modifier=Modifier){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Header(modifier)
        Spacer(modifier=Modifier.height(10.dp))
        Banner(modifier=Modifier.height(200.dp))
        Text(
            text = "Categories",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier=Modifier.height(10.dp))
        CategoryView(modifier)
    }
}