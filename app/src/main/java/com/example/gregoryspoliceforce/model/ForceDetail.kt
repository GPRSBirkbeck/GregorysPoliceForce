package com.example.gregoryspoliceforce.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForceDetail(
    val description: String,
    val url: String, //TODO make URL
    @SerialName(value = "engagement-methods")
    val engagementMethods: List<EngagementMethod>,
    val telephone: String,
    val id: String,
    val name: String
)

@Serializable
data class EngagementMethod(
    val title: String, // todo appears optional
    val url: String, //TODO Make URL
    val description: String
)
