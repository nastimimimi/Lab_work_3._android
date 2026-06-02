package com.example.votingapp.model

data class VoteOption(
    val id: Int,
    val title: String,
    val description: String = "",
    val votes: Int = 0
)
