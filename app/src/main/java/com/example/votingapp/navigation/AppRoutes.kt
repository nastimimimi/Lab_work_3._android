package com.example.votingapp.navigation

object AppRoutes {
    const val VOTE_LIST = "vote_list"
    const val ADD_VOTE = "add_vote"
    const val VOTE_DETAILS = "vote_details/{optionId}"

    fun voteDetails(optionId: Int) = "vote_details/$optionId"
}
