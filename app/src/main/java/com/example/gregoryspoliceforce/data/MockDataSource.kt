package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.EngagementMethod
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
            ForceDetail("h2.A police service for everyone\n\t\n\tLeicestershire Constabulary provides a policing service to the people of Leicester, Leicestershire and Rutland 24-hours a day, 365-days of the year.\n\nThe area we are responsible for covers over 2,500 square kilometres (over 965 square miles) and has a population of nearly one million. There is a rich diversity of communities all with their own policing needs.\n\nMany steps have been taken to bring policing back into the very heart of local communities. This has included the replacement of older, larger or out-of-town police buildings with modern, self-contained local policing units in the very centre of local communities.\n\nEach of the 15 local policing units is headed by an inspector whose responsibility is to ensure that their area receives a 24-hour policing service.\n\nTo help them provide this service they are supported by specialist departments such as the dog section, the scientific support department and the East Midlands air support unit.\n\nRather than waiting for crimes to be committed, we are working more and more to plan operations and target criminals. Many of these operations, which are aimed at tackling specific problems, involve working in partnership with local residents and other agencies and have proved to be very successful.\n\nOver the years we have forged close working relationships with local communities, other organisations and agencies and we continue to develop and strengthen these partnerships, working together to fight crime and improve the quality of life for everyone.",
            "http://www.leics.police.uk",
                listOf(
                    EngagementMethod(
                        "http://www.twitter.com/leicspolice",
                        "Keep up to date with Leicestershire Constabulary on Twitter",
                        "Twitter"),
                    EngagementMethod(
                        "http://www.twitter.com/leicspolice",
                        "Keep up to date with Leicestershire Constabulary on Twitter",
                        "Twitter")
                ),
        "0116 222 2222",
        "leicestershire",
         "Leicestershire Constabulary"
        )
        )
    }

}