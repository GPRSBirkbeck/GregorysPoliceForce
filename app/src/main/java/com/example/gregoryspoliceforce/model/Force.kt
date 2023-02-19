package com.example.gregoryspoliceforce.model
import kotlinx.serialization.Serializable

@Serializable
data class Force(
    val id: String? = null,
    val name: String? = null,
)
