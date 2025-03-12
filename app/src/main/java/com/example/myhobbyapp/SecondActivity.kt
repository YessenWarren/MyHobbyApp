package com.example.myhobbyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myhobbyapp.ui.theme.MyHobbyAppTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyHobbyAppTheme {
                SecondScreen()
            }
        }
    }
}

@Composable
fun SecondScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.football),
            contentDescription = "Football Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Футбол — это захватывающая командная игра, объединяющая миллионы людей по всему миру. Важно владеть техникой, тактикой и уметь работать в команде!",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            (context as? ComponentActivity)?.apply {
                finish()
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            }
        }) {
            Text(text = "Go Back")
        }
    }
}
