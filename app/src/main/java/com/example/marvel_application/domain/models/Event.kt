package com.example.marvel_application.domain.models

data class Event(
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var imagePath: String? = null,
    var imageExtension: String? = null
)