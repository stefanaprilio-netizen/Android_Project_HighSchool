package com.example.kampustangerang

data class Campus(
    val name: String,
    val location: String,
    val description: String,
    val imageUrl: String = "" // In a real app, this would be a URL or resource ID
)
