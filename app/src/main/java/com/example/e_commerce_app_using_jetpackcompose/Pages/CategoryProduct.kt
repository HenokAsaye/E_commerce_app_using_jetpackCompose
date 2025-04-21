package com.example.e_commerce_app_using_jetpackcompose.Pages

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.e_commerce_app_using_jetpackcompose.components.ProductView
import com.example.e_commerce_app_using_jetpackcompose.model.CategoryModel
import com.example.e_commerce_app_using_jetpackcompose.model.ProductModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable


fun CategoryProduct(modifier: Modifier = Modifier, navController: NavHostController,categoryId:String){
    val productList = remember {
        mutableStateOf<List<ProductModel>>(emptyList())
    }

    LaunchedEffect(key1 = Unit) {
        Firebase.firestore.collection("data").document("Stock").collection("Products")
            .whereEqualTo("category",categoryId)
            .get().addOnCompleteListener(){
                if(it.isSuccessful){
                    val resultList = it.result.documents.mapNotNull{
                            doc ->
                        doc.toObject(ProductModel::class.java)
                    }
                    productList.value = resultList.plus(resultList).plus(resultList)
                }
            }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize()
            .padding(16.dp)
    ){
        items(productList.value.chunked(2)){rowItems ->
            Row{
                rowItems.forEach{
                    ProductView(product = it, modifier = Modifier.weight(1f))
                }
                if(rowItems.size == 1){
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}