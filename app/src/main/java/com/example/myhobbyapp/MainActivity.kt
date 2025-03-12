package com.example.myhobbyapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.example.myhobbyapp.ui.theme.MyHobbyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyHobbyAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val activity = context as ComponentActivity
    val rootView = LocalView.current // Получаем корневой View

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Main Screen", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val intent = Intent(context, SecondActivity::class.java)


                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity,
                    Pair.create(rootView, "screen_transition")
                )

                context.startActivity(intent, options.toBundle())
            }) {
                Text("Next")
            }
        }
    }
}
