package com.jesusmoreira.comicteca.model

data class Images (
        val tiny: String? = null,
        val small: String? = null,
        val medium: String? = null,
        val large: String? = null,
        val original: String? = null,
        val meta: Meta? = Meta()
)