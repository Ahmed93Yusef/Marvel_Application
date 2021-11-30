package com.example.marvel_application.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun LiveData<Event<NavDirections>>.observeEvent(owner: LifecycleOwner, navController: NavController){
    this.observe(owner, { event ->
        event?.getContentIfNotHandle()?.let { command ->
            navController.navigate(command)
        }
    })
}