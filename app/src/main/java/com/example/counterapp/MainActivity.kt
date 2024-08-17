package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(value = 0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = counter.toString(), fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            ButtonCounter(
                type = { counter-- },
                nameOfButton = "Decrease",
                colorOfButton = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
            )
            Spacer(modifier = Modifier.width(10.dp))
            ButtonCounter(
                type = { counter++ },
                nameOfButton = "Increase",
                colorOfButton = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}

@Composable
fun ButtonCounter(
    type: () -> Unit,
    nameOfButton: String,
    colorOfButton: ButtonColors,
) {
    Button(onClick = type, colors = colorOfButton) {
        Text(text = nameOfButton)
    }
}