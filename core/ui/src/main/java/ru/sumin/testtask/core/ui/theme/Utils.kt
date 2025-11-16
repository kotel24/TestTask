package ru.sumin.testtask.core.ui.theme

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.formatDate(): String {
    return try {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
        val date = LocalDate.parse(this, inputFormatter)
        val outputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
        date.format(outputFormatter)
    } catch (e: Exception) {
        this
    }
}