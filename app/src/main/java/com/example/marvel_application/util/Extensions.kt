package com.example.marvel_application.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import java.math.BigInteger
import java.security.MessageDigest

fun LiveData<EventHandled<NavDirections>>.observeEvent(owner: LifecycleOwner, navController: NavController){
    this.observe(owner, { event ->
        event?.getContentIfNotHandle()?.let { command ->
            navController.navigate(command)
        }
    })
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}