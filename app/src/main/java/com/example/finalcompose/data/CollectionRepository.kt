package com.example.finalcompose.data

import com.example.finalcompose.model.CollectionData

class CollectionRepository {
    fun getAllCollection(type: String): List<CollectionData> {
        return if (type == "fauna")
            faunaItems
        else floraItems
    }

    fun getOneCollection(type: String, collectionId: String): CollectionData? {
        val collections: List<CollectionData> = if (type == "fauna") faunaItems else floraItems
        return collections.find { it.label == collectionId }
    }
}