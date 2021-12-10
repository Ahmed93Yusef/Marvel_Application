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

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCharacterDtoToSearchEntity(charactersDto: CharactersDto): SearchEntity

    fun convertCharacterEntityToDomain(charactersEntity: CharactersEntity): Characters

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCharacterDtoToDomain(charactersDto: CharactersDto): Characters

    // Comic Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertComicDtoToEntity(comicDto: ComicDto): ComicEntity

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertComicDtoToSearchEntity(comicDto: ComicDto): SearchEntity

    fun convertComicEntityToDomain(comicEntity: ComicEntity): Comic

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertComicDtoToDomain(comicDto: ComicDto): Comic

    // Creators Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCreatorsDtoToEntity(creatorsDto: CreatorsDto): CreatorsEntity

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCreatorsDtoToSearchEntity(creatorsDto: CreatorsDto): SearchEntity

    fun convertCreatorsEntityToDomain(creatorsEntity: CreatorsEntity): Creators

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertCreatorsDtoToDomain(creatorsDto: CreatorsDto): Creators

    // Event Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertEventDtoToEntity(eventDto: EventDto): EventEntity

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertEventDtoToSearchEntity(eventDto: EventDto): SearchEntity

    fun convertEventEntityToDomain(eventEntity: EventEntity): Event

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertEventDtoToDomain(eventDto: EventDto): Event

    // Series Convertor
    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertSeriesDtoToEntity(seriesDto: SeriesDto): SeriesEntity

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertSeriesDtoToSearchEntity(seriesDto: SeriesDto): SearchEntity

    fun convertSeriesEntityToDomain(seriesEntity: SeriesEntity): Series

    @Mapping(target = "imagePath", source = "thumbnail.path")
    @Mapping(target = "imageExtension", source = "thumbnail.extension")
    fun convertSeriesDtoToDomain(seriesDto: SeriesDto): Series

    fun convertResentSearchEntityToDomain(searchEntity: SearchEntity): Search
}