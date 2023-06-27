package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_detail

import dev.leonardom.Lab_0005.firebaseLab5.model.Information

data class InfoDetailState (
    val isLong: Boolean=false,
    val information: Information? = null,
    val error: String = ""

        )