package com.example.capstonetest2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.capstonetest2.ui.theme.CapstoneTest2Theme

@Composable
fun MapScreen(navController: NavController) {
    CapstoneTest2Theme {
        Column(


            modifier = Modifier
                .fillMaxSize()



        ) {
            Text(
                text = "This is the map screen"
            )
        }

    }

}
