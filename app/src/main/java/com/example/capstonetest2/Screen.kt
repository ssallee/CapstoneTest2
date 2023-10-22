package com.example.capstonetest2

import androidx.annotation.StringRes

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object MyPets : Screen("MyPets")
    object Messenger : Screen("Messenger")
    object Map : Screen("Map")
}

