package com.example.composeappintents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// 1. Layout imports
import androidx.compose.foundation.layout.*

// 2. Core Compose imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

// 3. Material 3 Wildcard (Fixes Text, MaterialTheme, Surface, and darkColorScheme)
import androidx.compose.material3.*

class SecondActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Use the built-in 'intent' object directly. 
        // Use quotes around your keys, and add a fallback string just in case!
        val name = intent.getStringExtra("name") ?: "No Name Provided"
        val email = intent.getStringExtra("email") ?: "No Email Provided"
        val mobile = intent.getStringExtra("mobile") ?: "No Mobile Provided"
        
        setContent {
            // Force Dark Mode
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Component(name, email, mobile)
                }
            }
        }
    } 
}

@Composable
fun Component(name: String, email: String, mobile: String) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SecondActivity!", fontSize = 40.sp)
        
        // Add a little gap before the data
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(text = "Name: $name", fontSize = 20.sp)
        Text(text = "Email: $email", fontSize = 20.sp)
        Text(text = "Mobile: $mobile", fontSize = 20.sp)
    }
}