package com.example.ticker_board_android.views.ticker.smallcomponents

import com.example.ticker_board_android.views.ticker.TickerIndex


object AlphabetMapper {
    private val Alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789•".toList()

    val size: Int = Alphabet.size

    fun getLetterAt(index: Int): Char = Alphabet[index % size]

    fun getIndexOf(letter: Char, offset: Int = 0): TickerIndex {
        var index = Alphabet.indexOf(letter.uppercaseChar())
        index = if (index < 0) Alphabet.lastIndex else index
        val offsetIndex = if (index < offset) {
            index + (size * (offset / size + 1))
        } else {
            index
        }
        return TickerIndex(rawIndex = index, offsetIndex = offsetIndex)
    }
}