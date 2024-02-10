package com.example.ticker_board_android.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import com.example.ticker_board_android.ui.theme.Ticker_board_androidTheme
import com.example.ticker_board_android.views.home.UserInput

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ticker_board_androidTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                  topBar = { TopAppBar(title = { Text(text = "Ticker Jetpack Compose")}) }
                ){
                    UserInput(it)
                }
            }
        }
    }
}


