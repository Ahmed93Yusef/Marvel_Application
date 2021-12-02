package com.example.marvel_application.domain.mapper

import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.model.remote.response.characters.CharactersDto

class CharacterMapperById: Mapper<CharactersDto, Characters> {
    override fun map(input: CharactersDto): Characters {
        return Characters(
            id = input.id,
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}