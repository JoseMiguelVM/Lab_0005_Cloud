package dev.leonardom.Lab_0005.firebaseLab5.presentation.info_list.components

import android.icu.text.IDNA.Info
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import dev.leonardom.Lab_0005.firebaseLab5.model.Information
import dev.leonardom.Lab_0005.ui.theme.Red100
import dev.leonardom.Lab_0005.ui.theme.Yellow600

@ExperimentalMaterialApi
@Composable
fun InfoListItem(
    info: Information
) {
    Card(
        elevation = 0.dp
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clickable {
                    TODO("ON ITEM CLICK")
                }
        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    text = "Fecha: " + info.fecha,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    text = "Humedad del suelo: " + info.temperatura,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    text = info.comentario,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                )

                Button(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    onClick = {},
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Red100
                    )
                ) {
                    Text(
                        text = "Ver mas informacion",
                        color = Color.White
                    )
                }
            }
        }
    }
}