package com.example.capstonetest2

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
//import androidx.navigation.NavController
import com.example.capstonetest2.ui.theme.CapstoneTest2Theme

//TODO Create a separate file for each screen

@Composable
fun HomeScreen(navController: NavController){
    Column(


        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)



    ) {
        Text(
            text = "This is the Home page"
        )
    }

}


@Composable
fun PlaceholderScreen(navController: NavController){
    Column(


        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)


    ) {
        Text(
            text = "This is a placeholder page"
        )
    }

}

@Composable
fun SettingsScreen(navController: NavController){
    Column(


        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)


    ) {
        Text(
            text = "This is the settings screen"
        )
    }

}




/*@Preview
@Composable
fun HomePreview(){
    CapstoneTest2Theme {
        HomeScreen()
    }
}

 */