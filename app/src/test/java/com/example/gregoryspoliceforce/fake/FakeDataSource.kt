package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.datamodel.EngagementMethod
import com.example.gregoryspoliceforce.datamodel.Force
import com.example.gregoryspoliceforce.datamodel.ForceDetail

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
            "Leicestershire Police"
        )

}
