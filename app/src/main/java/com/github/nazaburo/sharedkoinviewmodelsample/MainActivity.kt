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
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.github.nazaburo.sharedkoinviewmodelsample.navigation.Screen
import com.github.nazaburo.sharedkoinviewmodelsample.ui.screen.ScreenA as ScreenAComposable
import com.github.nazaburo.sharedkoinviewmodelsample.ui.screen.ScreenB as ScreenBComposable
import com.github.nazaburo.sharedkoinviewmodelsample.ui.theme.MyApplicationTheme
import com.github.nazaburo.sharedkoinviewmodelsample.viewmodel.SharedViewModel
import org.koin.compose.viewmodel.sharedKoinViewModel

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
                        startDestination = Screen.ScreenRoute,
                    ) {
                        navigation<Screen.ScreenRoute>(
                            startDestination = Screen.ScreenA,
                        ) {
                            composable<Screen.ScreenA> {
                                val sharedViewModel = it.sharedKoinViewModel<SharedViewModel>(navController)
                                ScreenAComposable(
                                    onNavigateToScreenB = {
                                        navController.navigate(Screen.ScreenB)
                                    },
                                    viewModel = sharedViewModel
                                )
                            }

                            composable<Screen.ScreenB> {
                                val sharedViewModel = it.sharedKoinViewModel<SharedViewModel>(navController)

                                ScreenBComposable(
                                    onNavigateBack = {
                                        navController.popBackStack()
                                    },
                                    viewModel = sharedViewModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}