package com.example.gregoryspoliceforce.model

import java.net.URL

data class ForceDetail(
    val description: String,
    val url: URL,
    val engagementMethods: List<EngagementMethods>,
    val telephone: String,
    val id: String,
    val name: String
)

data class EngagementMethods(
    val title: String,
    val url: URL,
    val description: String
)
