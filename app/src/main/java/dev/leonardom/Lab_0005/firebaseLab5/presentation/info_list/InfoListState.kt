package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list

import dev.leonardom.Lab_0005.firebaseLab5.model.Information

data class InfoListState(
    val isLoading: Boolean = false,
    val infos: List<Information> = emptyList(),
    val error: String = ""
)