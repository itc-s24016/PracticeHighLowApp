package com.example.practicehighlowapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicehighlowapp.ui.theme.PracticeHighLowAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeHighLowAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    val com = remember { mutableIntStateOf((1..13).random()) }
    val you = remember { mutableIntStateOf((1..13).random()) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "相手のカード", fontSize = 20.sp)
        Text(
            text = com.value.toString(),
            fontSize = 48.sp
        )
        Text(text = "あなたのカード", fontSize = 20.sp)
        Text(
            text = you.value.toString(),
            fontSize = 48.sp
        )
        Button(onClick = {
            com.intValue = (1..13).random()
            you.intValue = (1..13).random()
        }) {
            Text(text = "次のゲーム", fontSize = 20.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    PracticeHighLowAppTheme {
        Main()
    }
}