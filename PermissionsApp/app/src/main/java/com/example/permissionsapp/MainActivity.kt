package com.example.permissionsapp

import android.Manifest

import android.content.pm.PackageManager

import androidx.activity.result.contract.ActivityResultContracts

// 1. Core Android (Intents, Bundles, Context, Logs, Application)
import android.os.*
import android.content.*
import android.util.*
import android.app.*

// 2. AndroidX Modern Activities (AppCompatActivity, Permissions)
import androidx.appcompat.app.*
import androidx.core.app.*
import androidx.core.content.*

// 3. XML View System Foundation (View, ViewGroup, MotionEvent)
import android.view.*
import android.view.View.*

// 4. Standard UI Widgets (TextView, Button, EditText, ImageView, Toast)
import android.widget.*

// 5. Graphics & Drawables (Colors, Bitmaps, custom shapes)
import android.graphics.*
import android.graphics.drawable.*

// 6. Fragments (If app uses Fragments instead of just Activities)
import androidx.fragment.app.*

// 7. RecyclerView & Cards (Common in XML lists)
import androidx.recyclerview.widget.*
import androidx.cardview.widget.*


class MainActivity : AppCompatActivity() {


    private val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        granted -> 
        if(granted) {openCamera()}
        else { Toast.makeText(this,"Camera Permission Required",Toast.LENGTH_LONG).show() }
    }
    private val code = 100
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val granted = checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        if(granted) {openCamera()}
        else { launcher.launch(Manifest.permission.CAMERA) }
    }
    private fun openCamera() {
        Toast.makeText(this,"Camera opening",Toast.LENGTH_LONG).show()
    }
}
