package com.example.marvel_application.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "SEARCH_TABLE")
data class SearchEntity(
    @PrimaryKey var id: Long?,
    var name: String?,
    var description: String?,
    var modified: String?,
    var imagePath: String?,
    var imageExtension: String?,
    var date: Date? = Date()
)
