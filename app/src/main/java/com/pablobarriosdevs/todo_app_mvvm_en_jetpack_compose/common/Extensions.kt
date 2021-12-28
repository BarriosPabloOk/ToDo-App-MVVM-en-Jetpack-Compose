package com.pablobarriosdevs.easytask.common

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

//formatting the parameter string to a new format accordingly to DayComponent
fun String.makeFormat(): String{
    return this.uppercase()
        .replace(".", "")
}

fun Date.format(pattern: String = "dd"): String{
    return SimpleDateFormat(pattern, Locale.getDefault())
        .format(this).toString()
}

fun Long.formatLong(pattern: String = "dd"): String{
    return SimpleDateFormat(pattern, Locale.getDefault())
        .format(this).toString()
}