package dev.leonardom.Lab_0005.firebaseLab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.leonardom.Lab_0005.firebaseLab5.navigation.Destination
import dev.leonardom.Lab_0005.firebaseLab5.presentation.info_detail.InfoDetailScreen
import dev.leonardom.Lab_0005.firebaseLab5.presentation.info_detail.InfoDetailViewModel
import dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list.InfoListScreen
import dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list.InfoListViewModel
import dev.leonardom.Lab_0005.ui.theme.FirebaseCRUDTheme

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseCRUDTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Destination.InfoList.route,
                ){
                    addBookList(navController)

                    addBookDetail()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
fun NavGraphBuilder.addBookList(
    navController: NavController
){
    composable(
        route = Destination.InfoList.route
    ){
        val viewModel: InfoListViewModel = hiltViewModel()
        val state = viewModel.state.value
        val isRefreshing = viewModel.isRefreshing.collectAsState()

        InfoListScreen(
            state = state,
            navigateToBookDetail = {
                navController.navigate(Destination.InfoDetail.route)
            },
            isRefreshing = isRefreshing.value,
            refreshData = viewModel::getInfoList
        )
    }
}

fun NavGraphBuilder.addBookDetail() {
    composable(
        route = Destination.InfoDetail.route
    ){
        val viewModel: InfoDetailViewModel = hiltViewModel()
        val state = viewModel.state.value

        InfoDetailScreen(
            state = state,
            addNewInfo = viewModel::addNewInfo
        )
    }
}