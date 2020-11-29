package com.jesusmoreira.comicteca.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jesusmoreira.comicteca.R
import com.jesusmoreira.comicteca.model.Manga
import com.jesusmoreira.comicteca.ui.style.ComictecaTheme
import com.jesusmoreira.comicteca.ui.style.typography
import com.skydoves.landscapist.glide.GlideImage

private const val TAG: String = "CustomCards"

@Preview
@Composable
fun PreviewCard() {
    CollectionCard(
        item = Manga.randomDummyManga(),
        Modifier.preferredHeight(180.dp).preferredWidth(120.dp)
    )
}

@Composable
fun CollectionCard(item: Manga, modifier: Modifier = Modifier) {
    ComictecaTheme {
        Card(
            modifier.clickable(onClick = {}),
            elevation = 4.dp,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                GlideImage(
                    imageModel = item.attributes?.coverImage?.medium ?: item.attributes?.posterImage?.medium ?: "",
                    contentScale = ContentScale.Crop,
                    circularRevealedEnabled = true,
                    error = imageResource(id = R.drawable.header)
                )

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Surface(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = item.attributes?.canonicalTitle ?: "",
                            style = typography.body2,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyCard(modifier: Modifier = Modifier) = Box(modifier) {}
