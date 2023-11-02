package com.example.capstonetest2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.capstonetest2.ui.theme.CapstoneTest2Theme




@Composable
fun MyPetsScreen(navController: NavController) {


    CapstoneTest2Theme {
        Column(


            modifier = Modifier
                .fillMaxSize()


        ) {
            MyPetsColumn()

        }

    }
}

//input screen
@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun createPet(){

    Column(

    ) {
        var petName by rememberSaveable {
            mutableStateOf("")
        }
        var breedType by rememberSaveable {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = petName,
            onValueChange = { petName = it },
            label = { Text("name") },
            singleLine = true
        )
        OutlinedTextField(
            value = breedType,
            onValueChange = { breedType = it },
            label = { Text("breed") },
            singleLine = true
        )

        Button(onClick = { /*TODO make a new pet using the info from the form*/ }) {
          Text("+ Add My Pet")
       }
    }
}

@Composable
fun MyPetsCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun MyPetsColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement= Arrangement.spacedBy(8.dp),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)


    )
    {
        items(myPetsData){item ->
            MyPetsCard(item.drawable, item.text)
        }
    }
}

//test data
private val myPetsData = listOf(
    R.drawable.cat2 to R.string.cat2,
    R.drawable.cat to R.string.cat,
    R.drawable.dog to R.string.dog,
    R.drawable.dog2 to R.string.dog2,
    R.drawable.water_dog to R.string.water_dog,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_cat to R.string.water_cat
).map { DrawablStringPair(it.first, it.second) }

//TODO fix this later its a copy of a class in a different file
private data class DrawablStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview() {
    CapstoneTest2Theme { MyPetsColumn() }
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