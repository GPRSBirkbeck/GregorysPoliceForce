package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail

class MockDataSource {
    // TODO remove as hardcoded here and not in strings is not best practice
    fun LoadMockPoliceSource(): List<Force> {
        return listOf<Force>(
            Force("london-met", "London Metropolitan"),
            Force("leicester", "Leicester"),
            Force("cams", "Cambridge"),
            Force("london-city", "London City Force")
            )
    }

    fun LoadMockPoliceDetailSource(): List<ForceDetail> {
        return listOf<ForceDetail>(

        )
    }

}