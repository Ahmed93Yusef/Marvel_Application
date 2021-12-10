package com.example.marvel_application.domain.mapper

import com.example.marvel_application.model.local.entity.SearchEntity
import com.example.marvel_application.model.remote.response.characters.CharactersDto

class ConvertSearchDtoToEntity {
    fun map(input: CharactersDto): SearchEntity{
        return SearchEntity(
            id = input.id?.toLong(),
            name = input.name,
            description = input.description,
            imagePath = input.thumbnail?.path,
            imageExtension = input.thumbnail?.extension,
            modified = input.modified,
        )

    }    }