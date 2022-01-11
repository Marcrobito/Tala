package dev.eighteentech.tala.entities

data class Item(
    val locale: String,
    val loan: Loan?,
    val timestamp: Long,
    val username: String
)

data class Loan(
    val status: String,
    val level: String,
    val due: Double?,
    val dueDate: Long?,
)

//num class