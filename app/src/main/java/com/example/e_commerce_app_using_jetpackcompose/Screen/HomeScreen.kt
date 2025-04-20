package com.example.e_commerce_app_using_jetpackcompose.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce_app_using_jetpackcompose.Pages.CartPage
import com.example.e_commerce_app_using_jetpackcompose.Pages.FavouritePage
import com.example.e_commerce_app_using_jetpackcompose.Pages.Homepage
import com.example.e_commerce_app_using_jetpackcompose.Pages.Profilepage
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable

fun HomeScreen(modifier:Modifier = Modifier,navController: NavController){

    val NavItemList = listOf(
        NavItem("Home",Icons.Default.Home),
        NavItem("Favourite",Icons.Default.Favorite),
        NavItem("Cart",Icons.Default.ShoppingCart),
        NavItem("Profile",Icons.Default.Person),
    )
    var selectedIndex by remember {
        mutableStateOf(0)
    }
   Scaffold(
       bottomBar = {
           NavigationBar {
               NavItemList.forEachIndexed{index,navitem ->
                   NavigationBarItem(
                       selected = index == selectedIndex,
                       onClick = {
                           selectedIndex = index
                       },
                       icon = {
                           Icon(imageVector = navitem.icon, contentDescription = navitem.label)

                       },
                       label = {Text(text=navitem.label)}
                   )

               }
           }
       }

   ){
       ContentScreen(modifier = modifier.padding(it),selectedIndex)
   }
}



@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex:Int){
    when(selectedIndex){
        0 -> Homepage(modifier)
        1 -> FavouritePage(modifier)
        2 -> CartPage(modifier)
        3 -> Profilepage(modifier)
    }
}

data class NavItem(
    val label:String,
    val icon:ImageVector
)



