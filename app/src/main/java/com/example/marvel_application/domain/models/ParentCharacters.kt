package com.example.marvel_application.domain.models

data class ParentCharacters(
    val character: List<Characters>? = null,
    val comic: List<Comic>? = null,
    val event: List<Event>? = null,
)
