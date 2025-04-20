package com.example.e_commerce_app_using_jetpackcompose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce_app_using_jetpackcompose.Pages.CategoryProduct
import com.example.e_commerce_app_using_jetpackcompose.Screen.AuthScreen
import com.example.e_commerce_app_using_jetpackcompose.Screen.HomeScreen
import com.example.e_commerce_app_using_jetpackcompose.Screen.LoginScreen
import com.example.e_commerce_app_using_jetpackcompose.Screen.SignUpScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable

fun AppNavigation(modifier : Modifier = Modifier){
    val navController = rememberNavController()
    GlobalNavigation.navController = navController
    val isLoggedin = Firebase.auth.currentUser != null
    val firstPage = if(isLoggedin) "home" else "auth"

    NavHost(navController = navController , startDestination = firstPage){
        composable("auth"){
            AuthScreen(modifier,navController)
        }

        composable("signup"){
            SignUpScreen(modifier,navController)
        }


        composable("login"){
            LoginScreen(modifier,navController)
        }
        composable("home"){
            HomeScreen(modifier,navController)
        }
        composable("productDetail/{categoryId}"){
            CategoryProduct(modifier,navController)
        }
    }

}


object GlobalNavigation{
    lateinit var navController: NavHostController
}
