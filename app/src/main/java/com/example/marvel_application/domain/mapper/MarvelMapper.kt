package com.example.marvel_application.domain.mapper

import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.model.remote.response.characters.CharactersDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface MarvelMapper {

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCharacterDtoToEntity(charactersDto: CharactersDto): CharactersEntity
}