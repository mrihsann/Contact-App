package com.ihsanarslan.contactapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object Detail : Screen

    @Serializable
    data object Settings : Screen
}