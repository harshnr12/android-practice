package com.example.composeapp

// 1. Core Android (Intents, Bundles, Logs)
import android.os.*
import android.content.*
import android.util.*

// 2. Activity & Compose Setup
import androidx.activity.*
import androidx.activity.compose.*

// 3. Compose Memory & State (remember, mutableStateOf)
import androidx.compose.runtime.*

// 4. Layouts & Structure (Column, Row, Box, Spacer, Arrangement)
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

// 5. Core UI & Modifiers (Modifier, Alignment)
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.*

// 6. Material Design 3 (Text, Button, TextField, MaterialTheme, Colors)
import androidx.compose.material3.*

// 7. Material Icons (If using built-in icons)
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*

import androidx.compose.ui.text.font.*

import android.net.Uri
import androidx.compose.ui.platform.LocalContext

import android.content.ActivityNotFoundException
import android.widget.Toast
import android.provider.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyComposeTemplate()
                }
            }
        }
    }
}

@Composable
fun MyComposeTemplate() {
    // Column stacks items vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Needs import androidx.compose.ui.unit.dp
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        // Icon acts as our Image for this template
        Icon(
            imageVector = Icons.Default.Build,
            contentDescription = "Build Icon",
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Compose Template Ready!",
            style = MaterialTheme.typography.headlineSmall
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Row stacks items horizontally
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* TODO: Add action */ }) {
                Text("Start")
            }
            
            OutlinedButton(onClick = { /* TODO: Add action */ }) {
                Text("Cancel")
            }
        }
    }
}
