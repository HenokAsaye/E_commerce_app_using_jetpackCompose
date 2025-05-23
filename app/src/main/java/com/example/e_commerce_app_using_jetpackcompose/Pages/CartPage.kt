package com.example.e_commerce_app_using_jetpackcompose.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_app_using_jetpackcompose.components.cartItemView
import com.example.e_commerce_app_using_jetpackcompose.model.userModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

@Composable


fun CartPage(modifier: Modifier=Modifier){

    val usermodel = remember {
        mutableStateOf(userModel())
    }

    LaunchedEffect(key1 = Unit){
        Firebase.firestore.collection("users")
            .document(FirebaseAuth.getInstance().currentUser?.uid!!)
            .get().addOnCompleteListener{
                if(it.isSuccessful){
                    val result = it.result.toObject(userModel::class.java)
                    if(result != null){
                        usermodel.value = result
                    }
                }
            }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text= "Your Cart",style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )

        LazyColumn {
            items(usermodel.value.cartItems.toList()){(productId,qty)->
                cartItemView(modifier,productId = productId,qty=qty)
            }
        }

    }
}