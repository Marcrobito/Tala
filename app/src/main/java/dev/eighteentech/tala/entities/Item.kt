package dev.eighteentech.tala.entities

import dev.eighteentech.tala.R

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
    val approved: Double?
)

enum class Status {
    DUE, PAID, APPROVED, UNKNOWN;

    companion object {

        fun status(name: String) = when (name) {
            "due" -> DUE
            "paid" -> PAID
            "approved" -> APPROVED
            else -> UNKNOWN
        }

    }
}

enum class Level {
    GOLD, SILVER, BRONZE, UNKNOWN;

    fun getResource() =
        when (this) {
            GOLD -> R.drawable.img_gold_badge_large
            SILVER -> R.drawable.img_silver_badge_large
            BRONZE -> R.drawable.img_bronze_badge_large
            UNKNOWN -> R.drawable.img_blue_badge_large
        }


    companion object {

        fun level(name: String) = when (name) {
            "gold" -> GOLD
            "silver" -> SILVER
            "bronze" -> BRONZE
            else -> UNKNOWN
        }

    }
}