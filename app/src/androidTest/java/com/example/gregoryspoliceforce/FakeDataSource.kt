package com.example.gregoryspoliceforce

import com.example.gregoryspoliceforce.data.model.EngagementMethod
import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.data.model.ForceDetail

object FakeDataSource {
    val fakeForceList = listOf<Force>(
        Force("london-met", "London Metropolitan"),
        Force("leicester", "Leicester"),
        Force("cams", "Cambridge"),
        Force("london-city", "London City Force")
    )
    val fakeForceDetail = ForceDetail(
            "A police service for everyone.",
            "http://www.leics.police.uk",
            listOf(
                EngagementMethod(
                    "http://www.twitter.com/leicspolice",
                    "Keep up to date with Leicestershire Constabulary on Twitter",
                    "Twitter", "bla"
                ),
                EngagementMethod(
                    "http://www.twitter.com/leicspolice",
                    "Keep up to date with Leicestershire Constabulary on Twitter",
                    "Twitter", "bla"
                )
            ),
            "0116 222 2222",
            "leicestershire",
            "Leicestershire Constabulary"
        )

    val emptyList = listOf<Force>()

}
