package com.axis.student.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("colleges")
class CollegeDetails(
    @Id
    val id :String,
    val name: String,
    val city: String,
    val pincode: String

    )