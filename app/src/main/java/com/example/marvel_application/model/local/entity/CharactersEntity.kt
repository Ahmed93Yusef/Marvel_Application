package com.example.marvel_application.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTERS_TABLE")
data class CharactersEntity(
    @PrimaryKey var id: Long?,
    var name: String?,
    var description: String?,
    var modified: String?,
    var imagePath: String?,
    var imageExtension: String?
)
