package com.example.ticker_board_android.views.ticker

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.example.ticker_board_android.utils.Utils.TickerCycleMillis

@Stable
class TickerStateHolder {
    private val animatable = Animatable(0f)

    val value: Float
        get() = animatable.value

    val index: Int
        get() = animatable.value.toInt()

    suspend fun animateTo(target: TickerIndex) {
        val currentIndex = animatable.value.toInt()
        val result = animatable.animateTo(
            targetValue = target.offsetIndex.toFloat(),
            animationSpec = tween(
                durationMillis = (target.offsetIndex - currentIndex) * TickerCycleMillis,
                easing = FastOutSlowInEasing,
            )
        )
        if (result.endReason == AnimationEndReason.Finished) {
            snapTo(target.index)
        }
    }

    private suspend fun snapTo(index: Int) {
        animatable.snapTo(index.toFloat())
    }
}

@JvmInline
value class TickerIndex private constructor(private val packedIndex: Int) {
    val index: Int
        get() = (packedIndex and 0xFFFF0000.toInt()) shr 16

    val offsetIndex: Int
        get() = packedIndex and 0x0000FFFF

    companion object {
        operator fun invoke(
            rawIndex: Int,
            offsetIndex: Int,
        ) = TickerIndex(
            ((rawIndex and 0x0000FFFF) shl 16) + (offsetIndex and 0x0000FFFF)
        )
    }
}

@Composable
fun rememberTickerState() = remember {
    TickerStateHolder()
}