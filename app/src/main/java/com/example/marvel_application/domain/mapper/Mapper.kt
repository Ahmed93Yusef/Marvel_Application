package com.example.marvel_application.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}