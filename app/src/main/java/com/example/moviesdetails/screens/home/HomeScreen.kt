package com.example.moviesdetails.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesdetails.model.Movie
import com.example.moviesdetails.model.getMovies
import com.example.moviesdetails.navigation.MovieScreens
import com.example.moviesdetails.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Movies")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        MainContent(paddingValues = it, navController = navController)
    }
}

@Composable
fun MainContent(
    paddingValues: PaddingValues,
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Surface(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn() {
                items(items = movieList) {
                    MovieRow(movie = it) { movie ->
                        //Log.d("TAG", "MainContent: $movie")
                        navController.navigate(
                            route = MovieScreens.DetailsScreen.name + "/$movie"
                        )
                    }
                }
            }
        }
    }
}