package com.jesusmoreira.comicteca.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.random.Random

data class Manga (
    val id: String? = "0",
    val type: String? = "manga",
    val links: Link? = Link(),
    val attributes: Attributes? = Attributes(),
//    val relationShips: RelationShip = RelationShip(),
) {
    companion object {
        fun randomDummyManga() : Manga {
            return when(Random(System.currentTimeMillis()).nextInt(4)) {
                0 -> Manga(attributes = Attributes(canonicalTitle = "Tsubasa RESERVoir CHRoNiCLE", coverImage = Images(medium = "https://media.kitsu.io/manga/poster_images/27/small.jpg?1434249452")))
                1 -> Manga(attributes = Attributes(canonicalTitle = "Magi: The Labyrinth of Magic", coverImage = Images(medium = "https://media.kitsu.io/manga/poster_images/25108/small.jpg?1537103182")))
                2 -> Manga(attributes = Attributes(canonicalTitle = "Love Hina", coverImage = Images(medium = "https://media.kitsu.io/manga/poster_images/47/small.jpg?1434")))
                else ->Manga(attributes = Attributes(canonicalTitle = "The Promised Neverland", coverImage = Images(medium = "https://media.kitsu.io/manga/poster_images/38047/small.jpg?1490648273")))
            }
        }
    }
}