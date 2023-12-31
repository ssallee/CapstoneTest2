package com.example.capstonetest2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue

import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior
import androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.capstonetest2.ui.theme.CapstoneTest2Theme



//TODO move class to its own file

data class BottomNavigationItem(

    //This is the text that will display below the icon
    val title: String,

    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,

    //only change this during the constructor if the title will differ than the navigation route
    val nav: String = title,

    //This shows a single dot next to the icon
    val hasNews: Boolean,

    //this shows a number in a circle next to the icon
    val badgeCount: Int? = null

)

val items = listOf(


    BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,

        ),
    BottomNavigationItem(
        title = "My Pets",
        selectedIcon = Icons.Filled.Star,
        unselectedIcon = Icons.Outlined.Star,
        nav = "MyPets",
        hasNews = false,
        badgeCount = null

    ),

    BottomNavigationItem(
        title = "Messenger",
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.Email,
        hasNews = false,

        ////////////////////////////////////////////
        //this will have to be built out in a way
        //to dynamically change based on new messages
        //received. Right now it just shows a default
        //value
        //////////////////////////////////////////////
        badgeCount = 37

    ),


    BottomNavigationItem(
        title = "Map",
        selectedIcon = Icons.Filled.LocationOn,
        unselectedIcon = Icons.Outlined.LocationOn,

        //currently set to on for testing purposes
        hasNews = true


    ),
    //Additional navigation pages can go here
)


//this is a test comment for github


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CapstoneTest2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        topBar = {
                            TopAppBar(

                                /*colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.primary,
                                ),*/

                                title = {
                                    Text("Top app bar")
                                },
                                scrollBehavior = exitUntilCollapsedScrollBehavior()
                            )
                        },

                        bottomBar = { BottomNavigation(navController)}
                    ) {


                        //TODO move navHost to its own file
                        NavHost(navController, startDestination = Screen.Home.route) {
                            composable(Screen.Home.route) { HomeScreen(navController) }
                            composable(Screen.MyPets.route) { MyPetsScreen(navController) }
                            composable(Screen.Messenger.route) { MessengerScreen(navController) }
                            composable(Screen.Map.route) { MapScreen(navController) }

                        }
                        //Greeting(name = "Sam", Modifier)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomNavigation(navController: NavController, modifier: Modifier = Modifier){
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()


        //this was used in the documentation code for knowing what page is
        //currently selected, however I used a different method
        //TODO consider deleting currentDestination
        //val currentDestination = navBackStackEntry?.destination

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.nav) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }

                },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if(item.badgeCount != null){
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            }else if (item.hasNews){
                                Badge()
                            }

                        }
                    ) {
                        Icon(imageVector = if(index == selectedItemIndex){
                            item.selectedIcon
                        }else item.unselectedIcon,
                            contentDescription = item.nav
                        )

                    }
                }
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}






