package com.example.e_commerce_app_using_jetpackcompose.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable

fun Banner(modifier:Modifier = Modifier){

    var bannerList by remember{
        mutableStateOf<List<String>>(emptyList())
    }
    LaunchedEffect(Unit) {
        Firebase.firestore.collection("data")
            .document("Banner")
            .get().addOnCompleteListener(){
                bannerList = it.result.get("URL") as List<String>
            }
    }
    Text(
        text = (bannerList.toString())
    )
}