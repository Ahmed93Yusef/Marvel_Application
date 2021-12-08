package com.example.marvel_application.util

class EventHandled<out T>(private val content: T) {

    private var hasBeenHandled = false

    fun getContentIfNotHandle(): T? {

        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

}
