package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// 1. Layout imports (Column, Row, Box, Spacer, Padding)
import androidx.compose.foundation.layout.*

// 2. UI Components (Text, Button, Icon, MaterialTheme)
import androidx.compose.material3.*

// 3. Built-in Icons (so you don't need to add image files manually yet)
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build

// 4. Core Compose imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
