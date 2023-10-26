package com.example.capstonetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MyPetsScreen(navController: NavController){



    Column(


        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)


    ) {
        Text(
            text = "This is my mom's cat"
        )
        Image(painter = painterResource(id = R.drawable.cat2), contentDescription = "cat")
    }

}
/*
@Preview
@Composable
fun PetPreview(){

Row (verticalAlignment = Alignment.CenterVertically){


    Image(

        painter = painterResource(id = R.drawable.cat2),
        contentDescription = "cat"
        //modifier = Modifier.size(300.dp)
    )
    Text(text = "Sadie")
}


}

 */