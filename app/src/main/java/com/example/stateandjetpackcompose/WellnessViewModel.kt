package com.example.stateandjetpackcompose

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTask().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item:WellnessTask){
        _tasks.remove(item)
    }

}

private fun getWellnessTask() = List<WellnessTask>(30) {
    WellnessTask(it, "Task # $it")
}