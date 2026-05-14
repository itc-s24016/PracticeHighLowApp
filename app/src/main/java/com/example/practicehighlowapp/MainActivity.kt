package com.example.practicehighlowapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
    var message by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "相手のカード", fontSize = 20.sp)
        Box (
            modifier = Modifier
                .width(120.dp)
                .height(160.dp)
                .padding(8.dp)
                .border(2.dp, Color.Black)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = com.intValue.toString(),
                fontSize = 48.sp
            )
        }
        Text(text = "あなたのカード", fontSize = 20.sp)
        Box (
            modifier = Modifier
                .width(120.dp)
                .height(160.dp)
                .padding(8.dp)
                .border(2.dp, Color.Black)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (message.isEmpty()) "??" else you.intValue.toString(),
                fontSize = 48.sp
            )
        }
        if (message.isEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Button(
                    onClick = {
                        if (com.intValue == you.intValue) {
                            message = "引き分け"
                        } else if (com.intValue < you.intValue) {
                            message = "あなたの勝ち"
                        } else {
                            message = "あなたの負け"
                        }
                    },
                ) {
                    Text(text = "High", fontSize = 20.sp)
                }
                Button(
                    onClick = {
                        if (com.intValue == you.intValue) {
                            message = "引き分け"
                        } else if (com.intValue > you.intValue) {
                            message = "あなたの勝ち"
                        } else {
                            message = "あなたの負け"
                        }
                    },
                ) {
                    Text(text = "Low", fontSize = 20.sp)
                }
            }
        } else {
            Button(onClick = {
                com.intValue = (1..13).random()
                you.intValue = (1..13).random()
                message = ""
            }) {
                Text(text = "次のゲーム", fontSize = 20.sp)
            }
        }
        Text(text = message, fontSize = 28.sp)
    }
}
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    PracticeHighLowAppTheme {
        Main()
    }
}