package com.jesusmoreira.comicteca.ui.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewGrid() {
    Grid(listSize = 5) { position, modifier ->
        Card(modifier.clickable(onClick = {}),
            elevation = 4.dp,){
            Text("$position")
        }
    }
}

@Composable
fun Grid(
    listSize: Int,
    columns: Int = 3,
    modifier: Modifier = Modifier,
    padding: Dp = 8.dp,
    preferredSize: Dp = 180.dp,
    children: @Composable (position: Int, modifier: Modifier) -> Unit
) {
    Column(modifier = modifier
        .padding(padding)
        .fillMaxSize()) {
        for (i in 0..listSize / columns) {
            Row(Modifier.padding(vertical = padding).fillMaxWidth()) {
                for (j in 0 until columns) {
                    val position = (i * columns) + j

                    Spacer(Modifier.preferredSize(padding))
                    if (position < listSize) {
                        children(
                            position,
                            Modifier
                                .weight(1f, true)
                                .preferredHeight(preferredSize)
                        )
//                        Card(Modifier
//                            .weight(1f, true)
//                            .preferredHeight(preferredSize)){
//                            Text("$i - $j ($position)")
//                        }
                    } else {
                        EmptyCard(Modifier
                            .weight(1f, true)
                            .preferredHeight(preferredSize))
                    }
                    Spacer(Modifier.preferredSize(padding))
                }
            }
        }
    }
}