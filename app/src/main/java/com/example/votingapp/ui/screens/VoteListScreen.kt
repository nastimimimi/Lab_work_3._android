package com.example.votingapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.votingapp.model.VoteOption
import com.example.votingapp.viewmodel.VoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteListScreen(
    viewModel: VoteViewModel,
    onAddClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val options by viewModel.options.collectAsState()
    val leader by viewModel.leader.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "🏆 Голосування",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        if (leader != null && leader!!.votes > 0) {
                            Text(
                                text = "Лідер: ${leader!!.title} (${leader!!.votes} голосів)",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        } else {
                            Text(
                                text = "Голосування ще не розпочато",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Додати варіант")
            }
        }
    ) { padding ->
        if (options.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Натисніть + щоб додати перший варіант",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(items = options, key = { it.id }) { option ->
                    VoteListItem(
                        option = option,
                        isLeader = leader != null && leader!!.votes > 0 && option.id == leader!!.id,
                        onClick = { onItemClick(option.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun VoteListItem(
    option: VoteOption,
    isLeader: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isLeader)
        MaterialTheme.colorScheme.primaryContainer
    else
        MaterialTheme.colorScheme.surface

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                if (isLeader) {
                    Text("🏆", fontSize = 20.sp, modifier = Modifier.padding(end = 8.dp))
                }
                Column {
                    Text(
                        text = option.title,
                        fontSize = 16.sp,
                        fontWeight = if (isLeader) FontWeight.Bold else FontWeight.Normal
                    )
                    if (option.description.isNotBlank()) {
                        Text(
                            text = option.description,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1
                        )
                    }
                }
            }
            Text(
                text = "${option.votes} 👍",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
