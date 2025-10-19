package com.github.nazaburo.sharedkoinviewmodelsample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import org.koin.compose.viewmodel.koinViewModel

@Composable
inline fun <reified VM : ViewModel> NavBackStackEntry.sharedKoinViewModelFixed(
    navController: NavController,
    navGraphRoute: Any? = this.destination.parent?.route,
): VM {
    val navGraphRoute = navGraphRoute ?: return koinViewModel<VM>()
    val parentEntry = remember(this) {
        if (navGraphRoute is String) {
            navController.getBackStackEntry(navGraphRoute)
        } else {
            navController.getBackStackEntry(navGraphRoute)
        }

    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}
