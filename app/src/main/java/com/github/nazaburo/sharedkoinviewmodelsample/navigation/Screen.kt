package com.github.nazaburo.sharedkoinviewmodelsample.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object ScreenRoute

    @Serializable
    object ScreenA

    @Serializable
    object ScreenB
}
