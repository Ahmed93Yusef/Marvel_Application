package com.example.marvel_application.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SERIES_TABLE")
data class SeriesEntity(
    @PrimaryKey var id: Long?,
    var name: String?,
    var description: String?,
    var modified: String?,
    var imagePath: String?,
    var imageExtension: String?
)
