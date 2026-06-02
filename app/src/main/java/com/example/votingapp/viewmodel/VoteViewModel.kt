package com.example.votingapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.votingapp.model.VoteOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class VoteViewModel : ViewModel() {

    private val _options = MutableStateFlow<List<VoteOption>>(emptyList())
    val options: StateFlow<List<VoteOption>> = _options.asStateFlow()

    private val _leader = MutableStateFlow<VoteOption?>(null)
    val leader: StateFlow<VoteOption?> = _leader.asStateFlow()

    private var nextId = 0

    fun addOption(title: String, description: String) {
        if (title.isBlank()) return
        val newList = _options.value + VoteOption(
            id = nextId++,
            title = title.trim(),
            description = description.trim()
        )
        _options.value = newList.sortedByDescending { it.votes }
        updateLeader()
    }

    fun vote(id: Int) {
        val newList = _options.value
            .map { if (it.id == id) it.copy(votes = it.votes + 1) else it }
            .sortedByDescending { it.votes }
        _options.value = newList
        updateLeader()
    }

    fun deleteOption(id: Int) {
        _options.value = _options.value.filter { it.id != id }
        updateLeader()
    }

    fun getOptionById(id: Int): VoteOption? = _options.value.find { it.id == id }

    private fun updateLeader() {
        _leader.value = _options.value.maxByOrNull { it.votes }
    }
}
