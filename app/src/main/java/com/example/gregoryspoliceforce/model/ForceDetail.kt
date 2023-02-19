package com.example.gregoryspoliceforce.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForceDetail(
    val description: String? = null,
    val url: String? = null, //TODO make URL
    @SerialName(value = "engagement_methods")
    val engagementMethods: List<EngagementMethod>,
    val telephone: String? = null,
    val id: String? = null,
    val name: String? = null
)

@Serializable
data class EngagementMethod(
    val title: String? = null, // todo appears optional
    val url: String? = null, //TODO Make URL
    val description: String? = null,
    val type: String? = null,
)
