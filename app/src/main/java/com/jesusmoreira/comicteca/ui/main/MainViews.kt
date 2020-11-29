package com.jesusmoreira.comicteca.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import com.jesusmoreira.comicteca.model.Manga
import com.jesusmoreira.comicteca.ui.components.BottomActionBar
import com.jesusmoreira.comicteca.ui.components.BottomActionBarController
import com.jesusmoreira.comicteca.ui.components.BottomNavigationScreen
import com.jesusmoreira.comicteca.ui.login.LogInScreen
import com.jesusmoreira.comicteca.ui.screens.ComictecaScreen
import com.jesusmoreira.comicteca.ui.screens.CommunityScreen
import com.jesusmoreira.comicteca.ui.screens.NewsScreen

@Composable
fun MainScreen(
        viewModel: MainViewModel,
        bottomNavigationItems: List<BottomNavigationScreen>,
        navController: NavHostController,
) {

    val isLogged by viewModel.isLogged().observeAsState(initial = false)

    if (!isLogged) {
        LogInScreen { userName, password ->
            viewModel.logIn(userName, password)
        }
    } else {

        val mangaList by viewModel.mangaList.observeAsState(initial = emptyList())

        if (mangaList.isEmpty()) {
            MainScreenLoading()
        } else {
            MainScreenComponent(mangaList, bottomNavigationItems, navController)
        }

    }
}

@Composable
fun MainScreenLoading() {
    // Column is a composable that places its children in a vertical sequence. You
    // can think of it similar to a LinearLayout with the vertical orientation.
    // In addition we also pass a few modifiers to it.

    // You can think of Modifiers as implementations of the decorators pattern that are
    // used to modify the composable that its applied to. In this example, we configure the
    // Column composable to occupy the entire available width and height using
    // Modifier.fillMaxSize().
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // A pre-defined composable that's capable of rendering a circular progress indicator. It
        // honors the Material Design specification.
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
    }
}

@Composable
fun MainScreenComponent(
        mangaList: List<Manga>,
        bottomNavigationItems: List<BottomNavigationScreen>,
        navController: NavHostController,
) {
    Scaffold(
            topBar = {

            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    // Add Volume
                }) {
                    Icon(Icons.Default.Add)
                }
            },
            bottomBar = {
                BottomActionBar(navController, bottomNavigationItems)
            },
    ) {
        BottomActionBarController(
                navController,
                onComicteca = { ComictecaScreen(mangaList) },
                onNews = {
                    NewsScreen()
                },
                onCommunity = { CommunityScreen() },
        )
    }
}

@Preview
@Composable
fun MainScreenLoadingPreview() {
    MainScreenLoading()
}

@Preview
@Composable
fun MainScreenComponentPreview() {
    MainScreenComponent(
            List(12) { Manga.randomDummyManga() },
            listOf(
                    BottomNavigationScreen.Comicteca,
                    BottomNavigationScreen.News,
                    BottomNavigationScreen.Community,
            ),
            rememberNavController()
    )
}