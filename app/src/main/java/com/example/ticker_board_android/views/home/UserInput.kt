package com.example.ticker_board_android.views.home

import TickerBoard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticker_board_android.utils.Utils

@Composable
fun UserInput(paddingValues: PaddingValues) {
    var text by remember { mutableStateOf(Utils.DUMMY_TEXT) }
    var rowCount by remember {
        mutableIntStateOf(0)
    }
    var columnCount by remember {
        mutableIntStateOf(7)
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier.fillMaxSize()
        .padding(paddingValues),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text(Utils.TEXT_HINT) },
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                modifier = Modifier.fillMaxWidth(),
                // Add any other optional parameters you wish below
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                // Handle the button click, perhaps add the text to a list
                keyboardController?.hide()
            }) {
                Text(Utils.SUBMIT_BUTTON_TEXT)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            rowCount = if (text.isNotEmpty()) (text.length-1) / 7 + 1 else rowCount
            columnCount = if (text.length <= 7) text.length
            else if (text.contains(" ") && text.length <= 7) text.substringBefore(" ").length
            else columnCount

            TickerBoard(
                numColumns = columnCount,
                numRows = rowCount,
                text = text,
                fontSize = 44.sp
            )
        }
    }
}


