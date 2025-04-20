package com.example.e_commerce_app_using_jetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType

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
    Column(
        modifier = modifier
    ){
        val pager = rememberPagerState(0) {
            bannerList.size
        }
        HorizontalPager(
            state = pager,
            pageSpacing = 24.dp
        ) {
            AsyncImage(
                model = bannerList.get(it),
                contentDescription = "Banner Image",
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .height(180.dp)
                    .background(color = Color.Blue)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        DotsIndicator(
            dotCount = bannerList.size,
            type = ShiftIndicatorType(
                DotGraphic(
                    color = MaterialTheme.colorScheme.primary,
                    size = 6.dp
            )
            ),
            pagerState = pager
        )

    }
}


