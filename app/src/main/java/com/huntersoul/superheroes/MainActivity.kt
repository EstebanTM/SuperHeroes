package com.huntersoul.superheroes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huntersoul.superheroes.model.HeroesList
import com.huntersoul.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HeroMain()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroMain(modifier: Modifier = Modifier){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .size(56.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.h1,
                )
            }
        }
    ) {
        HeroListScreen()
    }
}

@Composable
fun HeroListScreen() {
    val heroes = HeroesList.heroes
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(heroes) { hero ->
            HeroListItem(hero = hero)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroesTheme {
        HeroMain()
    }
}