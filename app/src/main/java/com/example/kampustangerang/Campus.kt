package com.example.kampustangerang

data class Campus(
    val name: String,
    val location: String,
    val description: String,
    val rector: String,
    val imageUrl: String = "",
    val faculties: List<Faculty> = emptyList()
) {
    constructor(
        name: String,
        location: String,
        description: String,
        url: String,
        imageUrl: String,
        s6: String
    ) : this() {

    }
}

data class Faculty(
    val name: String,
    val dean: String,
    val studyPrograms: List<StudyProgram>
)

data class StudyProgram(
    val name: String,
    val headOfProgram: String
)
