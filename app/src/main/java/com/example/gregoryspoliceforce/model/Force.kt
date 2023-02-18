package com.example.gregoryspoliceforce.model
import kotlinx.serialization.Serializable

@Serializable
data class Force(
    val id: String,
    val name: String
)
