package com.example.gregoryspoliceforce.model

data class ForceDetail(
    val description: String,
    val url: String, //TODO make URL
    val engagementMethods: List<EngagementMethod>,
    val telephone: String,
    val id: String,
    val name: String
)

data class EngagementMethod(
    val title: String, // todo appears optional
    val url: String, //TODO Make URL
    val description: String
)
