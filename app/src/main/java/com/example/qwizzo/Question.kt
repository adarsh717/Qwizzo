package com.example.qwizzo

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    var selectedAnswer : Int = -1
)