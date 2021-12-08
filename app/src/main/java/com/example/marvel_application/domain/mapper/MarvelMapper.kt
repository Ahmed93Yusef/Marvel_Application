package com.example.marvel_application.domain.mapper

import com.example.marvel_application.domain.models.*
import com.example.marvel_application.model.local.entity.*
import com.example.marvel_application.model.remote.response.characters.CharactersDto
import com.example.marvel_application.model.remote.response.comic.ComicDto
import com.example.marvel_application.model.remote.response.creators.CreatorsDto
import com.example.marvel_application.model.remote.response.event.EventDto
import com.example.marvel_application.model.remote.response.series.SeriesDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface MarvelMapper {

    // Character Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCharacterDtoToEntity(charactersDto: CharactersDto): CharactersEntity

    fun convertCharacterEntityToDomain(charactersEntity: CharactersEntity): Characters

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCharacterDtoToDomain(charactersDto: CharactersDto): Characters

    // Comic Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertComicDtoToEntity(comicDto: ComicDto): ComicEntity

    fun convertComicEntityToDomain(comicEntity: ComicEntity): Comic

    // Creators Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCreatorsDtoToEntity(creatorsDto: CreatorsDto): CreatorsEntity

    fun convertCreatorsEntityToDomain(creatorsEntity: CreatorsEntity): Creators

    // Event Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertEventDtoToEntity(eventDto: EventDto): EventEntity

    fun convertEventEntityToDomain(eventEntity: EventEntity): Event

    // Series Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertSeriesDtoToEntity(seriesDto: SeriesDto): SeriesEntity

    fun convertSeriesEntityToDomain(seriesEntity: SeriesEntity): Series
}