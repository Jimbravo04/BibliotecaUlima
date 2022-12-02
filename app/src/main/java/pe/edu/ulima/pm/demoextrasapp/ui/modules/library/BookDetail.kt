package pe.edu.ulima.pm.demoextrasapp.ui.modules.library

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.time.LocalDateTime
import kotlin.math.round

@Composable
fun BookDetail(navigatorController: NavHostController) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)

    )
    {
        Column(
            Modifier
                .width(260.dp)
                .height(150.dp)
                .border(width = 2.dp, Color.Black),
        ){
            Text(text = "Titulo: ", fontSize = 30.sp)
            Text(text = "Autor: ")
            Text(text = "Pie de imprenta: ")
            Text(text = "Descripcion fisica: ")
            Text(text = "ISBN: ")
        }
        Column(
            Modifier
                .width(260.dp)
                .height(50.dp)
                .border(width = 2.dp, Color.Black),
        ){
            Text(text = "Codigo de clasificacion: ")
            Text(text = "Localización: ")
            Text(text = "Copias: ")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            Modifier
                .width(260.dp)
                .height(50.dp)
                .border(width = 2.dp, Color.Black),
        ) {
            Text(text = "Disponibilidad: ")

            Button(
                onClick = { },
            ) {
                Text("RESERVAR")
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("NOTIFICAR DE DISPONIBILIDAD")
        }
    }
}