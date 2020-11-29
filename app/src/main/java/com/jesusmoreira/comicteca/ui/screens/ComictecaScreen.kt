package com.jesusmoreira.comicteca.ui.screens

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jesusmoreira.comicteca.R
import com.jesusmoreira.comicteca.model.Manga
import com.jesusmoreira.comicteca.ui.components.CollectionCard
import com.jesusmoreira.comicteca.ui.components.Grid

private const val TAG: String = "ComictecaScreen"

@Preview
@Composable
fun PreviewScreen() {
    ComictecaScreen(List(12) { Manga.randomDummyManga() })
}

@Composable
fun ComictecaScreen(items: List<Manga>) {
    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
    ) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) }
        )

        ScrollableColumn(contentPadding = PaddingValues(bottom = 56.dp)) {
            Grid(
                listSize = items.size,
                columns = 3,
            ) { position, modifier ->
                CollectionCard(
                    item = items[position],
                    modifier
                )
            }
        }
    }
}