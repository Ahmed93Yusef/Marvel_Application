package com.example.marvel_application.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTERS_TABLE")
data class CharactersEntity(
    @PrimaryKey val id: Long? =0L,
    @ColumnInfo val name: String? = null,
    @ColumnInfo val description: String? = null,
    @ColumnInfo val modified: String? = null,
    @ColumnInfo val imageUrl: String? = null
)
