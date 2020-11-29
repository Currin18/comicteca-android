package com.jesusmoreira.comicteca.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.comicteca.ui.components.BottomNavigationScreen
import com.jesusmoreira.comicteca.ui.style.ComictecaTheme

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContent {
            ComictecaTheme {
                MainScreen(
                    viewModel,
                    listOf(
                            BottomNavigationScreen.Comicteca,
                            BottomNavigationScreen.News,
                            BottomNavigationScreen.Community,
                    ),
                    rememberNavController()
                )
            }
        }
    }
}