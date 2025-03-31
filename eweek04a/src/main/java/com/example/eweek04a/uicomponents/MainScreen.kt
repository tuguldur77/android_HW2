package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // List of items for the ToDo list
    val todoList = remember { mutableStateListOf<Item>().apply { addAll(TodoItemFactory.makeTodoList()) } }

    // State to handle the switch toggle
    var showOnlyPending by remember { mutableStateOf(false) }

    // Filter the todoList based on the switch
    val filteredTodoList = if (showOnlyPending) {
        todoList.filter { it.status == TodoStatus.PENDING }
    } else {
        todoList
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title for the Todo List
        TodoListTitle()
        Spacer(modifier = Modifier.height(8.dp))

        // Row to display Text and Switch tightly together aligned to the left
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                "미완료 항목만 보기 ",
                modifier = Modifier.padding(end = 8.dp)
            )
            TodoSwitch(
                checked = showOnlyPending,
                onCheckedChange = { showOnlyPending = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Todo List with filtered list, filling remaining space.
        TodoList(filteredTodoList.toMutableStateList(), modifier = Modifier.weight(1f))

        // No Spacer with weight. Just spacer with small height
        Spacer(modifier = Modifier.height(8.dp))

        // TodoItemInput always at the bottom
        TodoItemInput(todoList)
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}