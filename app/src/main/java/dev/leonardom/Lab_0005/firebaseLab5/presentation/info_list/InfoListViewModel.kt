package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leonardom.Lab_0005.firebaseLab5.model.Information
import dev.leonardom.Lab_0005.firebaseLab5.repositories.InfoRepository
import dev.leonardom.Lab_0005.firebaseLab5.repositories.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class InfoListViewModel
@Inject
constructor(
    private val infoRepository: InfoRepository
): ViewModel(){
    private val _state: MutableState<InfoListState> = mutableStateOf(InfoListState())
    val state: State<InfoListState> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    init{
        getInfoList()

    }

    fun getInfoList(){
        infoRepository.getInfoList().onEach { result ->
            when(result){
                is Result.Error -> {
                    _state.value = InfoListState(error = result.message ?: "Error inesperado")

                }
                is Result.Loading -> {
                    _state.value = InfoListState(isLoading = true)

                }
                is Result.Success -> {
                    _state.value = InfoListState(infos = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}