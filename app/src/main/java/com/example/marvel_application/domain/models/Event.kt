package com.example.marvel_application.domain.models

data class Event(
    var id: Long?,
    var name: String?,
    var description: String?,
    var modified: String?,
    var imagePath: String?,
    var imageExtension: String?
)