import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticker_board_android.views.ticker.smallcomponents.Ticker


@Composable
fun TickerBoard(
    text: String,
    numColumns: Int,
    numRows: Int,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
    fontSize: TextUnit = 96.sp,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(8.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
) {
    val padded = text.padEnd(numColumns * numRows, ' ')
    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
    ) {
        repeat(numRows) { row ->
            TickerRow(
                text = padded.substring(startIndex = row * numColumns),
                numCells = numColumns,
                horizontalArrangement = horizontalArrangement,
                textColor = textColor,
                backgroundColor = backgroundColor,
                fontSize = fontSize,
            )
        }
    }
}

@Composable
fun TickerRow(
    text: String,
    numCells: Int,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
    fontSize: TextUnit = 96.sp,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(8.dp),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement
    ) {
        repeat(numCells) { index ->
            Ticker(
                letter = text.getOrNull(index) ?: ' ',
                textColor = textColor,
                backgroundColor = backgroundColor,
                fontSize = fontSize
            )
        }
    }
}










