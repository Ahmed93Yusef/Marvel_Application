package com.example.marvel_application.domain.mapper

import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.model.remote.response.characters.CharactersDto

class CharacterMapper: Mapper<CharactersDto, CharactersEntity> {
    override fun map(input: CharactersDto): CharactersEntity {
        return CharactersEntity(
            id = input.id?.toLong(),
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}