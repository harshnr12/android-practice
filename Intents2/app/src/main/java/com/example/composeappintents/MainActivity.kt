package com.example.intents2

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

class MainActivity : ComponentActivity() {
    
    private val TAG = "MY_APP_LOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(): called App is building the UI!")
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyComposeTemplate(
                        onSubmit = { name,email,mobile ->
                            val i = Intent(this,SecondActivity::class.java)
                            i.putExtra("name",name)
                            i.putExtra("email",email)
                            i.putExtra("mobile",mobile)
                            startActivity(i)
                        }
                    )
                }
            }
        }
    }
   
    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() called:App is now interactive!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called:App is hidden")
    }
  
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called: App killed")
    }

}

@Composable
fun MyComposeTemplate(onSubmit: (String, String, String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)   // Overall padding away from screen edges
            .verticalScroll(rememberScrollState()) // 1. Makes the column scrollable
            .imePadding(),// 2. Automatically pushes content up when keyboard opens
        // Center the whole block vertically
        verticalArrangement = Arrangement.Center, 
        // Center items horizontally
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        // --- THE FORM BLOCK ---
        // We nest a second Column just for the text fields so we can apply a uniform gap
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp) // Puts exactly 12dp between every TextField
        ) {
            TextField( 
                value = name, 
                onValueChange = { name = it }, 
                placeholder = { Text("Enter your name...") } 
            )
            
            TextField( 
                value = email, 
                onValueChange = { email = it }, 
                placeholder = { Text("Enter your email...") } 
            )
            
            TextField( 
                value = mobile, 
                onValueChange = { mobile = it }, 
                placeholder = { Text("Enter your mobile no...") } 
            )
        }

        // --- THE CUSTOM GAP ---
        // Creates a large, specific gap right before the button
        Spacer(modifier = Modifier.height(32.dp))

        Button( onClick = { onSubmit(name, email, mobile) }  ) { 
            Text(text = "Submit")
        }
    }
}