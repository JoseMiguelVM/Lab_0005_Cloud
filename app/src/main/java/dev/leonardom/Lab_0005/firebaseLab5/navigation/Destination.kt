package dev.leonardom.Lab_0005.firebaseLab5.navigation

import androidx.navigation.NamedNavArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object InfoList : Destination("infoList", emptyList())
    object InfoDetail: Destination("infoDetail", emptyList())
}
