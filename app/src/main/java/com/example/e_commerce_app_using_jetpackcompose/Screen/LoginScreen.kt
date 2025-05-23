package com.example.e_commerce_app_using_jetpackcompose.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.e_commerce_app_using_jetpackcompose.AppUtill.showToast
import com.example.e_commerce_app_using_jetpackcompose.R
import com.example.e_commerce_app_using_jetpackcompose.ViewModel.AuthViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier,navController: NavController, authViewModel: AuthViewModel= viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    var isLoading by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello There!",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Welcome Back sign in to your Account!",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 18.sp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Sign up image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                isLoading = true
                authViewModel.login(email,password){success,errorMessage ->
                    if(success){
                        isLoading =false
                        navController.navigate("home"){
                            popUpTo("auth"){inclusive=true}
                        }

                    }else{
                        isLoading = false
                        showToast(context,errorMessage?:"Some Thing Went Wrong")
                    }

                }
            },
            enabled = !isLoading,
            modifier = Modifier.fillMaxWidth()
                .height(60.dp)
        ){
            Text(
                text = if(isLoading) "Loading" else "Login",
                style = TextStyle(
                    fontSize = 22.sp,
                )
            )
        }
    }
}
