package com.ihsanarslan.contactapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ihsanarslan.contactapp.navigation.NavigationGraph
import com.ihsanarslan.contactapp.navigation.Screen
import com.ihsanarslan.contactapp.ui.theme.MyappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme (
                darkTheme = false
            ){
                NavigationGraph(
                    startDestination = Screen.Home
                )
            }
        }
    }
}