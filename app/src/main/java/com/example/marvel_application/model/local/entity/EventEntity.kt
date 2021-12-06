package com.example.marvel_application.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EVENT_TABLE")
data class EventEntity(
    @PrimaryKey var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var imagePath: String? = null,
    var imageExtension: String? = null
)
