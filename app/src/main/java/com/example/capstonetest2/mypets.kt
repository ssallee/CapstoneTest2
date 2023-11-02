package com.example.capstonetest2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

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
fun MyPetsScreen(navController: NavController){



    Column(


        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)


    ) {

        PetCategoryRow()
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
fun PetCategoryElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier

    ){
        Image(painter = painterResource(drawable),
            contentScale = ContentScale.Crop,

            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Composable
fun PetCategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement= Arrangement.spacedBy(8.dp),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)


    )
    {
        items(petCategoryData){ item ->
            PetCategoryElement(item.drawable, item.text)
        }
    }
}

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val petCategoryData = listOf(
    R.drawable.cat2 to R.string.cat2,
    R.drawable.cat to R.string.cat,
    R.drawable.dog to R.string.dog,
    R.drawable.dog2 to R.string.dog2,
    R.drawable.water_dog to R.string.water_dog,
    R.drawable.water_dog2 to R.string.water_dog2,
    R.drawable.water_cat to R.string.water_cat
).map { DrawableStringPair(it.first, it.second) }

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun PetCategoryElementPreview() {
    CapstoneTest2Theme {
        PetCategoryElement(
            text = R.string.water_cat,
            drawable = R.drawable.water_cat,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun PetCategoryRowPreview() {
    CapstoneTest2Theme { PetCategoryRow() }
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