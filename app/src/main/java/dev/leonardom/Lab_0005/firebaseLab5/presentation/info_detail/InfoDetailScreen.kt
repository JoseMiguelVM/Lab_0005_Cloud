package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.leonardom.Lab_0005.ui.theme.Red100

@Composable
fun InfoDetailScreen(
    state: InfoDetailState,
    addNewInfo: (String, String, String) -> Unit
) {

    var fecha by remember { mutableStateOf("") }
    var temperatura by remember { mutableStateOf("") }
    var comentario by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = fecha,
                onValueChange = { fecha = it},
                label = {
                    Text(text = "Ingrese Fecha")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = temperatura,
                onValueChange = { temperatura = it},
                label = {
                    Text(text = "Digite el porcentaje de humedad")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = comentario,
                onValueChange = { comentario = it},
                label = {
                    Text(text = "Ingrese comentario")
                }
            )
        }

        if(state.error.isNotBlank()){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = state.error,
                style = TextStyle(
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            )
        }

        if(state.isLong){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }else{
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                onClick = {
                    addNewInfo(fecha, temperatura, comentario)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Red100
                )
            ) {
                Text(
                    text = "Guardar informacion",
                    color = Color.White
                )
            }
        }
    }
}