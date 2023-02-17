package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force

class MockDataSource {
    fun LoadMockPoliceSource(): List<Force> {
        return listOf<Force>(
            Force("london-met", "London Metropolitan"),
            Force("leicester", "Leicester"),
            Force("cams", "Cambridge"),
            Force("london-city", "London City Force")
            )
    }
}