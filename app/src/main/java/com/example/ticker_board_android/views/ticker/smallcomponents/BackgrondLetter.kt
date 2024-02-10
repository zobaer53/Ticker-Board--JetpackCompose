package com.example.ticker_board_android.views.ticker.smallcomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
 fun BackgroundLetter(
    currentLetter: Char,
    nextLetter: Char,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
    fontSize: TextUnit = 96.sp,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp),
) {
    Column(
        modifier = modifier,
    ) {
        TopHalf {
            CenteredText(
                letter = nextLetter,
                textColor = textColor,
                backgroundColor = backgroundColor,
                fontSize = fontSize,
                contentPadding = contentPadding
            )
        }
        BottomHalf {
            CenteredText(
                letter = currentLetter,
                textColor = textColor,
                backgroundColor = backgroundColor,
                fontSize = fontSize,
                contentPadding = contentPadding
            )
        }
    }
}




