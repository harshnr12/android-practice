package com.example.intents2

// 1. Core Android (Intents, Bundles, Logs)
// 2. Activity & Compose Setup
// 3. Compose Memory & State (remember, mutableStateOf)
// 4. Layouts & Structure (Column, Row, Box, Spacer, Arrangement)
// 5. Core UI & Modifiers (Modifier, Alignment)
// 6. Material Design 3 (Text, Button, TextField, MaterialTheme, Colors)
import android.content.*
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme(colorScheme = darkColorScheme()) { MyComposeTemplate() } }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume() called: App is now interactive!")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop() called: App is hidden")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy() called: App killed")
    }
}

@Composable
fun MyComposeTemplate() {
    var txt by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
                onClick = {
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")).also {
                        context.startActivity(it)
                    }
                }
        ) { Text("Open Google") }

        Button(
                onClick = {
                    Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919450000000")).also {
                        context.startActivity(it)
                    }
                }
        ) { Text("Call Help") }

        Button(
                onClick = {
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { context.startActivity(it) }
                }
        ) { Text("Open Camera") }

        TextField(
                value = txt,
                onValueChange = { txt = it },
                label = { Text("Enter text") },
                maxLines = 1,
        )

        Button(
                onClick = {
                    Intent(Intent.ACTION_SEND)
                            .apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, txt)
                            }
                            .also { context.startActivity(it) }
                }
        ) { Text("Share Text") }

        Button(
                onClick = {
                    // 6. Fixed Picker constant and assigned type directly
                    Intent(Intent.ACTION_GET_CONTENT).apply { type = "image/*" }.also {
                        context.startActivity(it)
                    }
                }
        ) { Text("Pick Image") }

        Button(
                onClick = {
                    Intent(Intent.ACTION_SENDTO)
                            .apply {
                                data = Uri.parse("mailto:")

                                putExtra(Intent.EXTRA_EMAIL, arrayOf("support@example.com"))
                                putExtra(Intent.EXTRA_SUBJECT, "Feedback from App")
                                putExtra(Intent.EXTRA_TEXT, "I want to get my account Deleted.")
                            }
                            .also { context.startActivity(it) }
                }
        ) { Text("Send Email") }
    }
}
