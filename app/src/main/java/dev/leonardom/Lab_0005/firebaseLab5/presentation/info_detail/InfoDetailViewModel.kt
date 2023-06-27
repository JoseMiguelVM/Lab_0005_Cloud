package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leonardom.Lab_0005.firebaseLab5.model.Information
import dev.leonardom.Lab_0005.firebaseLab5.repositories.InfoRepository
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class InfoDetailViewModel
@Inject
constructor(
    private val infoRepository: InfoRepository
): ViewModel(){

    private val _state: MutableState<InfoDetailState> = mutableStateOf(InfoDetailState())
    val state: State<InfoDetailState>
        get() = _state

    fun addNewInfo(fecha: String, temperatura: String, comentario: String){
        val information = Information(
            id = UUID.randomUUID().toString(),
            fecha = fecha,
            temperatura = temperatura,
            comentario = comentario
        )
        infoRepository.addNewInfo(information)

    }
}