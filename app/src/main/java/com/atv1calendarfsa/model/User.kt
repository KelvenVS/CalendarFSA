package com.atv1calendarfsa.model

data class User(
    val id: Long = 0,
    val username: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String
)
