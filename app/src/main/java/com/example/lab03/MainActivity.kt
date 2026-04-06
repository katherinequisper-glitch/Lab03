package com.example.lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MenuPrincipal()
                }
            }
        }
    }
}

@Composable
fun MenuPrincipal() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        item { Text("Laboratorio 03 - Componentes", style = MaterialTheme.typography.headlineMedium) }
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item { EjemploCard() }
        item { Spacer(modifier = Modifier.height(10.dp)) }
        item { EjemploControlesSeleccion() }
        item { Spacer(modifier = Modifier.height(10.dp)) }
        item { EjemploProgress() }
        item { Spacer(modifier = Modifier.height(10.dp)) }
        item { EjemploBotonesNav() }
    }
}

@Preview(showBackground = true, name = "Ejemplo LazyVerticalGrid")
@Composable
fun EjemploGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.height(150.dp)) {
        items(4) { index ->
            Card(modifier = Modifier.padding(4.dp)) {
                Text("Grid Item $index", Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EjemploCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Componente: Card", style = MaterialTheme.typography.titleLarge)
            Text("Se usa para agrupar información con elevación y bordes.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EjemploControlesSeleccion() {
    var check by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableFloatStateOf(0.5f) }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = check, onCheckedChange = { check = it })
            Text("Checkbox / Checkbox")
        }
        Slider(value = sliderValue, onValueChange = { sliderValue = it })
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("OutlinedTextField") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EjemploProgress() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text("ProgressBar (Circular y Lineal)")
        CircularProgressIndicator(modifier = Modifier.padding(8.dp))
        LinearProgressIndicator(progress = { 0.7f }, modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun EjemploBotonesNav() {
    Column {
        Button(onClick = { }) {
            Icon(Icons.Default.Favorite, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Boton con Icono")
        }
        FloatingActionButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Icon(Icons.Default.Add, contentDescription = "FAB")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EjemploDialog() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = { TextButton(onClick = {}) { Text("Aceptar") } },
        title = { Text("AlertDialog") },
        text = { Text("Este es un control de alerta.") }
    )
}