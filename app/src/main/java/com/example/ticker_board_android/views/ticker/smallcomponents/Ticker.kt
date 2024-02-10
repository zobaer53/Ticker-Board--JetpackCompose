package com.example.ticker_board_android.views.ticker.smallcomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticker_board_android.views.ticker.TickerStateHolder
import com.example.ticker_board_android.views.ticker.rememberTickerState

@Composable
fun Ticker(
    letter: Char,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
    fontSize: TextUnit = 96.sp,
    contentPadding: PaddingValues = PaddingValues(all = 8.dp),
    state: TickerStateHolder = rememberTickerState(),
) {
    LaunchedEffect(key1 = letter) {
        val currentIndex = state.index
        val index = AlphabetMapper.getIndexOf(letter = letter, offset = currentIndex)
        state.animateTo(index)
    }
    val fraction = state.value - state.value.toInt()
    val rotation = -180f * fraction
    val currentLetter = AlphabetMapper.getLetterAt(state.index)
    val nextLetter = AlphabetMapper.getLetterAt(state.index + 1)
    Box(
        modifier = modifier
    ) {
        BackgroundLetter(
            currentLetter = currentLetter,
            nextLetter = nextLetter,
            textColor = textColor,
            backgroundColor = backgroundColor,
            fontSize = fontSize,
            contentPadding = contentPadding,
        )
        Box(
            modifier = Modifier
                .graphicsLayer {
                    rotationX = rotation
                    cameraDistance = 6f * density
                    transformOrigin = TransformOrigin(.5f, 1f)
                }
        ) {
            if (fraction <= .5f) {
                TopHalf {
                    CenteredText(
                        letter = currentLetter,
                        contentPadding = contentPadding,
                        textColor = textColor,
                        backgroundColor = backgroundColor,
                        fontSize = fontSize,
                    )
                }
            } else {
                BottomHalf(
                    modifier = Modifier.graphicsLayer {
                        rotationX = 180f
                    }
                ) {
                    CenteredText(
                        letter = nextLetter,
                        contentPadding = contentPadding,
                        textColor = textColor,
                        backgroundColor = backgroundColor,
                        fontSize = fontSize,
                    )
                }
            }
        }
    }
}