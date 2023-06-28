package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list.components.InfoList
import dev.leonardom.Lab_0005.ui.theme.Red100

@ExperimentalMaterialApi
@Composable
fun InfoListScreen(
    state : InfoListState,
    navigateToBookDetail: () -> Unit,
    isRefreshing: Boolean,
    refreshData: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToBookDetail,
                backgroundColor = Red100,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    ) {
        InfoList(
            state = state,
            isRefreshing = isRefreshing,
            refreshData = refreshData
        )
    }
}