package com.github.nazaburo.sharedkoinviewmodelsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.nazaburo.sharedkoinviewmodelsample.navigation.ScreenA
import com.github.nazaburo.sharedkoinviewmodelsample.navigation.ScreenB
import com.github.nazaburo.sharedkoinviewmodelsample.ui.screen.ScreenA
import com.github.nazaburo.sharedkoinviewmodelsample.ui.screen.ScreenA as ScreenAComposable
import com.github.nazaburo.sharedkoinviewmodelsample.ui.screen.ScreenB as ScreenBComposable
import com.github.nazaburo.sharedkoinviewmodelsample.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = ScreenA
                    ) {
                        composable<ScreenA> {
                            ScreenAComposable(
                                onNavigateToScreenB = {
                                    navController.navigate(ScreenB)
                                }
                            )
                        }

                        composable<ScreenB> {
                            ScreenBComposable(
                                onNavigateBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}