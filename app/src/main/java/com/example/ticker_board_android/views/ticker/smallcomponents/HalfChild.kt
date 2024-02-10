package com.example.ticker_board_android.views.ticker.smallcomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.Layout

@Composable
fun HalfChild(
    modifier: Modifier = Modifier,
    topHalf: Boolean = true,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier.clipToBounds(),
        content = content,
    ) { measurables, constraints ->
        require(measurables.size == 1) { "This composable expects a single child" }

        val placeable = measurables.first().measure(constraints)
        val height = placeable.height / 2

        layout(
            width = placeable.width,
            height = height,
        ) {
            placeable.placeRelative(
                x = 0,
                y = if (topHalf) 0 else -height,
            )
        }
    }
}

@Composable
fun TopHalf(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    HalfChild(
        modifier = modifier,
        topHalf = true,
        content = content,
    )
}

@Composable
fun BottomHalf(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    HalfChild(
        modifier = modifier,
        topHalf = false,
        content = content,
    )
}
