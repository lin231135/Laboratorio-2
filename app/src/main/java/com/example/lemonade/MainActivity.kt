package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/*
 * Autores: Javier Linares 231135 y Jorge Palacios 231385
 * Curso: PROGRAMACIÓN DE PLATAFORMAS MÓVILES
 * Fecha: 19/08/2024
 * Descripción: Implementación de una aplicación simple de Lemonade usando Jetpack Compose.
 */


// Esta es la actividad principal de la aplicación. ComponentActivity es la base de actividades que
// permite usar Jetpack Compose.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent establece el contenido de la actividad utilizando la función composable.
        setContent {
            // Se aplica el tema LemonadeTheme a la aplicación.
            LemonadeTheme {
                // Llama a la función composable que define la interfaz de usuario principal de la app.
                LemonadeApp()
            }
        }
    }
}

// Esta es la función principal que define la interfaz de usuario de la aplicación Lemonade.
@Composable
fun LemonadeApp() {
    // Se define un estado mutable para seguir la etapa actual del flujo (el paso del proceso).
    // `remember` se utiliza para recordar el valor del estado a lo largo de las recomposiciones.
    var currentStep by remember { mutableStateOf(1) }

    // Surface es un contenedor que se ajusta a todo el tamaño disponible y utiliza el color de fondo
    // del tema actual.
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // El flujo de la aplicación se controla mediante una estructura `when`, que cambia
        // la interfaz según el valor de `currentStep`.
        when (currentStep) {
            // Paso 1: Seleccionar un limón del árbol.
            1 -> {
                // Column organiza los elementos de forma vertical, centrados tanto horizontal como verticalmente.
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Muestra el texto que indica seleccionar un limón.
                    Text(text = stringResource(R.string.lemon_select))
                    // Espacio entre el texto y la imagen.
                    Spacer(modifier = Modifier.height(32.dp))
                    // Muestra la imagen del árbol de limones. Cuando se hace clic en la imagen, se cambia al paso 2.
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                // Cambia el paso al siguiente.
                                currentStep = 2
                            }
                    )
                }
            }
            // Paso 2: Exprimir el limón.
            2 -> {
                // Otra columna con los mismos alineamientos y disposiciones que en el paso 1.
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Muestra el texto que indica exprimir el limón.
                    Text(text = stringResource(R.string.lemon_squeeze))
                    // Espacio entre el texto y la imagen.
                    Spacer(modifier = Modifier.height(32.dp))
                    // Muestra la imagen del limón. Al hacer clic, se cambia al paso 3.
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                // Cambia el paso al siguiente.
                                currentStep = 3
                            }
                    )
                }
            }
            // Paso 3: Beber la limonada.
            3 -> {
                // Similar a las estructuras anteriores.
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Muestra el texto que indica beber la limonada.
                    Text(text = stringResource(R.string.lemon_drink))
                    // Espacio entre el texto y la imagen.
                    Spacer(modifier = Modifier.height(32.dp))
                    // Muestra la imagen de la limonada. Al hacer clic, se cambia al paso 4.
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemon_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                // Cambia el paso al siguiente.
                                currentStep = 4
                            }
                    )
                }
            }
            // Paso 4: El vaso está vacío; reinicia el flujo.
            4 -> {
                // Última estructura de columna para el flujo.
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Muestra el texto que indica que el vaso está vacío.
                    Text(text = stringResource(R.string.lemon_empty_glass))
                    // Espacio entre el texto y la imagen.
                    Spacer(modifier = Modifier.height(32.dp))
                    // Muestra la imagen del vaso vacío. Al hacer clic, se reinicia el flujo al paso 1.
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                // Reinicia el flujo al paso 1.
                                currentStep = 1
                            }
                    )
                }
            }
        }
    }
}

// Función de vista previa que permite ver el diseño en el editor sin ejecutar la app.
// Se aplica el tema LemonadeTheme y se llama a la función LemonadeApp.
@Preview
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}