package com.example.capstonetest2

import androidx.annotation.StringRes

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Placeholder : Screen("Placeholder")
    object Settings : Screen("Settings")
}

