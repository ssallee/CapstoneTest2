package com.example.capstonetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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

//input screen
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun createPet(){


    Column(

    ) {
        var petName by rememberSaveable {
            mutableStateOf("")
        }

        TextField(
            value = petName,
            onValueChange = { petName = it },
            label = { Text("name") },
            singleLine = true
        )
        TextButton(onClick = { /*TODO make a new pet using the info from the form*/ }) {
            Text("Add To My Pets")
        }
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