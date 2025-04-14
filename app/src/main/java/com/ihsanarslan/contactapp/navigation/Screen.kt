package com.ihsanarslan.contactapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data class Detail(
        val name : String,
        val surname : String,
        val email : String,
        val image : String
    ) : Screen

    @Serializable
    data object Settings : Screen

    @Serializable
    data object Add : Screen
}