package com.ihsanarslan.contactapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data class Detail(
        val id : Int
    ) : Screen

    @Serializable
    data object Settings : Screen

    @Serializable
    data object Add : Screen
}