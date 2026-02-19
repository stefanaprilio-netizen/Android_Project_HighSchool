package com.example.kampustangerang

data class Campus(
    val name: String,
    val location: String,
    val description: String,
    val imageUrl: String,
    val facilities: String,
    val registrationDate: String,
    val category: String = "Umum", // IPA, IPS, Bahasa, atau Umum
    val rector: String = "",
    val facultiesList: List<Faculty> = emptyList()
)

data class Faculty(
    val name: String,
    val dean: String,
    val studyPrograms: List<StudyProgram>
)

data class StudyProgram(
    val name: String,
    val headOfProgram: String
)
