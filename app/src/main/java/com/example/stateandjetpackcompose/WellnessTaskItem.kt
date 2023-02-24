package com.example.stateandjetpackcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WellnessTaskItem(taskName: String, modifier: Modifier = Modifier,onClose:()->Unit) {
    var checkedState by rememberSaveable {
        mutableStateOf(false)
    }
    WellnessTaskItem(taskName = taskName,
        checked = checkedState,
        onCheckChanged = { newValue ->
        checkedState = newValue
    }, onClose = onClose, modifier = modifier)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckChanged: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = taskName, modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        )
        Checkbox(checked = checked, onCheckedChange = onCheckChanged )
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

