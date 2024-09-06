package com.example.laundryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.laundryapp.navigation.AppNavHost
import com.example.laundryapp.ui.theme.LaundryAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaundryAPPTheme {
                AppNavHost()
            }
        }
    }
}


