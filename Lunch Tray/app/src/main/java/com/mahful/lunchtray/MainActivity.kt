package com.mahful.lunchtray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
// Import LunchTrayApp (Penting)
import com.mahful.lunchtray.ui.theme.LunchTrayApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Kita pakai MaterialTheme bawaan Android saja
            // Jadi tidak perlu mencari AddNavigationTheme atau LunchTrayTheme
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LunchTrayApp()
                }
            }
        }
    }
}