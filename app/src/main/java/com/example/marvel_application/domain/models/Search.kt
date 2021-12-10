package com.example.marvel_application.domain.models

import java.util.*

data class Search(
    var id: Long?,
    var name: String?,
    var description: String?,
    var modified: String?,
    var imagePath: String?,
    var imageExtension: String?,
    var date: Date? = Date()
)
