package com.jesusmoreira.comicteca.model

data class Attributes (
        val createdAt: String? = "",
        val updatedAt: String? = "",
        val slug: String? = "",
        val synopsis: String? = "",
        val coverImageTopOffset: Int? = 0,
        val titles: Map<String, String>? = mapOf(),
        val canonicalTitle: String? = "",
        val abbreviatedTitles: List<String>? = listOf(),
        val averageRating: String? = "",
        val ratingFrequencies: Map<String, String>? = mapOf(),
        val userCount: Int? = 0,
        val favoritesCount: Int? = 0,
        val startDate: String? = "",
        val endDate: String? = "",
        val popularityRank: Int? = 0,
        val ratingRank: Int? = 0,
        val ageRating: String? = "",
        val ageRatingGuide: String? = "",
        val subtype: String? = "",
        val status: String? = "",
        val tba: String? = "",
        val posterImage: Images? = Images(),
        val coverImage: Images? = Images(),
        val chapterCount: String? = null,
        val volumeCount: Int? = 0,
        val serialization: String? = "",
        val mangaType: String? = "",
)