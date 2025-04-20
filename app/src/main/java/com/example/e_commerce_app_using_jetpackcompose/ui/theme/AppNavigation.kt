package com.example.e_commerce_app_using_jetpackcompose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce_app_using_jetpackcompose.Screen.AuthScreen
import com.example.e_commerce_app_using_jetpackcompose.Screen.HomeScreen
import com.example.e_commerce_app_using_jetpackcompose.Screen.LoginScreen
import com.example.e_commerce_app_using_jetpackcompose.Screen.SignUpScreen

@Composable

fun AppNavigation(modifier : Modifier = Modifier){
    val navController = rememberNavController()


    NavHost(navController = navController , startDestination = "auth"){
        composable("auth"){
            AuthScreen(modifier,navController)
        }

        composable("signup"){
            SignUpScreen(modifier,navController)
        }


        composable("login"){
            LoginScreen(modifier)
        }
        composable("home"){
            HomeScreen(modifier)
        }
    }

}
