package com.axis.student.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("students")
data class PersonalDetails(
    val id: Int,
    val name: String,
    val branch: String,
    val cgpa:String,
    val universityName:String


    )