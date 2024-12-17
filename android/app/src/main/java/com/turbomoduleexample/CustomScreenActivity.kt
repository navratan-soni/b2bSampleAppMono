package com.turbomoduleexample

import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.turbomoduleexample.components.BottomNavBar
import com.turbomoduleexample.components.NavigationGraph
import com.turbomoduleexample.ui.theme.GWajob2bTheme

class CustomScreenActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra("message")

        // Create and set up the TextView
        val textView = TextView(this)
        if (message != null) {
            textView.text = message
        } else {
            textView.text = "Welcome to the custom screen!" // Default message
        }
        textView.textSize = 24f
        textView.setPadding(20, 20, 20, 20)

        setContentView(textView)

        enableEdgeToEdge()
        setContent {
            GWajob2bTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavBar(navController) }
                ) { paddingValues ->
                    Column (Modifier.padding(paddingValues)) {
                        // Add your custom screen content here

                    }
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
