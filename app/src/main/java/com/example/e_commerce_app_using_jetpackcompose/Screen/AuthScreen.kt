package com.example.e_commerce_app_using_jetpackcompose.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_commerce_app_using_jetpackcompose.R

@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavHostController){
    var scrollState = rememberScrollState()
    Column(
        modifier = modifier.fillMaxSize()
            .padding(25.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.img_1),
            contentDescription ="banner",
            modifier = modifier
                .fillMaxWidth()
                .height(400.dp)
//                .clip(RoundedCornerShape(16.dp)) // border radius
        )
//        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text="Start Your Shopping Journey",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center

            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text="Best ecom app with Best price",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center

            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("login")
        },
            modifier = Modifier.fillMaxWidth()
                .height(60.dp)
            ) {
            Text(
                text = "Login",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 22.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            navController.navigate("signup")
        },
            modifier = Modifier.fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 22.sp
                )
            )
        }
    }
}