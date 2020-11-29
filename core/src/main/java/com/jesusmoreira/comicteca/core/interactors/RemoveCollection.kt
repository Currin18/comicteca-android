package com.jesusmoreira.comicteca.core.interactors

import com.jesusmoreira.comicteca.core.data.CollectionRepository
import com.jesusmoreira.comicteca.core.domain.Collection
import com.jesusmoreira.comicteca.core.domain.Library

class RemoveCollection(private val collectionRepository: CollectionRepository) {
    suspend operator fun invoke(collection: Collection) =
        collectionRepository.removeCollection(collection)
}